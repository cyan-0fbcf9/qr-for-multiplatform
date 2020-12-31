package extenstion

import kotlinx.coroutines.Job
import kotlinx.coroutines.withTimeout
import java.awt.image.BufferedImage
import java.awt.image.ImageObserver
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

fun BufferedImage.toByteArray(type: String = "png"): ByteArray {
    return ByteArrayOutputStream().also { stream ->
        ImageIO.write(this, type, stream)
    }.toByteArray()
}

suspend fun BufferedImage.duplicate(specificationType: Int): BufferedImage =
    BufferedImage(this.width, this.height, specificationType).also {
        val job = Job()
        val observer = ImageObserver { _, _, _, _, _, _ ->
            job.complete()
            false
        }
        if (it.createGraphics().drawImage(this, 0, 0, observer)) {
            job.complete()
        } else {
            withTimeout(5000L) {
                job.join()
            }
        }
    }