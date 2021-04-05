package functions

import singleton.QR
import java.awt.Desktop
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.UnsupportedFlavorException
import java.awt.image.BufferedImage
import java.net.URI
import java.net.URISyntaxException

fun setClipboardListener() {
    Toolkit.getDefaultToolkit().systemClipboard.apply {
        addFlavorListener {
            try {
                val image = this.getData(DataFlavor.imageFlavor) as BufferedImage
                val scannedValue = QR.scan(image)
                val url = URI(scannedValue)
                Desktop.getDesktop().browse(url)
            } catch (e: UnsupportedFlavorException) {
                TODO("Log")
            } catch (e: URISyntaxException) {
                TODO("Log")
            } catch (e: Exception) {
                TODO("Log")
            }
        }
    }
}
