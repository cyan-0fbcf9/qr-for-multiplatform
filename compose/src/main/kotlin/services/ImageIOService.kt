package services

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toPixelMap
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import javax.imageio.ImageIO

class ImageIOService {
    fun export(image: ImageBitmap, path: String): Boolean {
        val data = image.toPixelMap().buffer.map { it.toByte() }.toByteArray()
        return try {
            export(ImageIO.read(ByteArrayInputStream(data)), path)
        } catch (e: FileNotFoundException) {
            throw e
        } catch (e: IOException) {
            false
        }
    }

    fun export(image: BufferedImage, path: String): Boolean {
        return try {
            ImageIO.write(image, "png", File(path))
        } catch (e: IOException) {
            false
        }
    }
}