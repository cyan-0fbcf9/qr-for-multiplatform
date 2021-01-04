package services

import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

class ImageIOService {
    fun export(image: BufferedImage, path: String): Boolean {
        return try {
            ImageIO.write(image, "png", File(path))
        } catch (e: IOException) {
            false
        }
    }
}