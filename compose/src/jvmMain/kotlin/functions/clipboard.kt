package functions

import modules.singleton.QR
import java.awt.Desktop
import java.awt.datatransfer.UnsupportedFlavorException
import java.awt.image.BufferedImage
import java.net.URI
import java.net.URISyntaxException

fun scanAndOpenQR(qrImage: BufferedImage) {
    try {
        val scannedValue = QR.scan(qrImage)
        val uri = URI(scannedValue)
        Desktop.getDesktop().browse(uri)
    } catch (e: UnsupportedFlavorException) {
        return
    } catch (e: URISyntaxException) {
        return
    } catch (e: Exception) {
        return
    }
}
