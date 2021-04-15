package services.clipboard

import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.FlavorListener
import java.awt.image.BufferedImage
import java.awt.image.MultiResolutionImage

abstract class ClipboardServiceableImpl(private val clipboard: Clipboard) : ClipboardServiceable {
    override fun getString(): String? {
        return try {
            clipboard.getData(DataFlavor.stringFlavor) as String
        } catch (e: Exception) {
            null
        }
    }

    override fun getImage(): BufferedImage? {
        try {
            val image = clipboard.getData(DataFlavor.imageFlavor)
            return when {
                image as? BufferedImage != null -> {
                    image
                }
                image as? MultiResolutionImage != null -> {
                    image.resolutionVariants.first() as BufferedImage
                }
                else -> {
                    null
                }
            }
        } catch (e: Exception) {
            return null
        }
    }

    fun addFlavorListener(listener: FlavorListener) {
        clipboard.addFlavorListener(listener)
    }
}