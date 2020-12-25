package logics.graphics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
import java.awt.image.BufferedImage
import java.awt.image.ImageObserver


suspend fun stackImageOnCenter(baseImage: BufferedImage, stackedImage: BufferedImage): Boolean =
    withContext(Dispatchers.Default) {
        val job = Job()
        job.start()
        val observer = ImageObserver { _, _, _, _, _, _ ->
            job.complete()
            true
        }
        val completion = baseImage.createGraphics().drawImage(
            stackedImage,
            (baseImage.width - stackedImage.width) / 2,
            (baseImage.height - stackedImage.height) / 2,
            observer
        )
        if (completion) job.complete()

        if (!completion) {
            withTimeoutOrNull(5000) {
                job.join()
            }
        }

        return@withContext job.isCompleted
    }