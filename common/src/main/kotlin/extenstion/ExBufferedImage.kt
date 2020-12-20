package extenstion

import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

fun BufferedImage.toByteArray(): ByteArray {
    return ByteArrayOutputStream().also { stream ->
        ImageIO.write(this, "png", stream)
    }.toByteArray()
}