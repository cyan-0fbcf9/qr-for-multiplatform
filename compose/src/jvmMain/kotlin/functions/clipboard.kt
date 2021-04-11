package functions

import modules.singleton.QR
import java.awt.Desktop
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.UnsupportedFlavorException
import java.awt.image.BufferedImage
import java.awt.image.MultiResolutionImage
import java.net.URI
import java.net.URISyntaxException
import kotlin.concurrent.fixedRateTimer

// TODO: storeで管理したい
private var lastQRUri: URI? = null

fun setClipboardListener() {
    val osName = System.getProperty("os.name").toLowerCase()
    when {
        osName.startsWith("win") || osName.startsWith("linux") -> {
            Toolkit.getDefaultToolkit().systemClipboard.addFlavorListener {
                val scannedUri = observeQRClipboard() ?: return@addFlavorListener
                if (lastQRUri == null) {
                    lastQRUri = scannedUri
                } else if (scannedUri != lastQRUri) {
                    Desktop.getDesktop().browse(scannedUri)
                    lastQRUri = scannedUri
                }
            }
        }
        osName.startsWith("mac") -> {
            fixedRateTimer("clipboard_observer", initialDelay = 500, period = 200) {
                val scannedUri = observeQRClipboard() ?: return@fixedRateTimer
                if (lastQRUri == null) {
                    lastQRUri = scannedUri
                } else if (scannedUri != lastQRUri) {
                    Desktop.getDesktop().browse(scannedUri)
                    lastQRUri = scannedUri
                }
            }
        }
        else -> {
            throw RuntimeException("os name is unexpected. [os.name: ${osName}]")
        }
    }
}

private fun observeQRClipboard(): URI? {
    try {
        val image =
            Toolkit.getDefaultToolkit().systemClipboard.getData(DataFlavor.imageFlavor)
        val scannedValue = when {
            image as? BufferedImage != null -> {
                QR.scan(image)
            }
            image as? MultiResolutionImage != null -> {
                QR.scan(image.resolutionVariants.first() as BufferedImage)
            }
            else -> {
                ""
            }
        }
        return URI(scannedValue)
    } catch (e: UnsupportedFlavorException) {
        return null
    } catch (e: URISyntaxException) {
        return null
    } catch (e: Exception) {
        return null
    }
}
