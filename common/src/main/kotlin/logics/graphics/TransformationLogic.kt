package logics.graphics

import kotlinx.coroutines.Job
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withTimeout
import java.awt.Image
import java.awt.image.BufferedImage
import java.awt.image.ImageObserver

class TransformationLogic {
    suspend fun resize(image: BufferedImage, width: Int, height: Int): BufferedImage {
        val job = Job()
        val observer = ImageObserver { _, _, _, _, _, _ ->
            job.complete()
            false
        }
        return BufferedImage(width, height, image.type).apply {
            if (createGraphics().drawImage(image.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING), 0, 0, observer))
                job.complete()
            else
                try {
                    withTimeout(3000) {
                        job.join()
                    }
                } catch (e: TimeoutCancellationException) {
                    throw e
                }
        }
    }

    suspend fun resize(image: BufferedImage, side: Int): BufferedImage {
        return resize(image, side, side)
    }
}