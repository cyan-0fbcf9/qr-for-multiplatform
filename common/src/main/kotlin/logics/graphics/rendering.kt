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
        val observer = ImageObserver { _, _, _, _, _, _ ->
            job.complete()
            false
        }
        val completion = baseImage.createGraphics().drawImage(
            stackedImage,
            (baseImage.width - stackedImage.width) / 2,
            (baseImage.height - stackedImage.height) / 2,
            observer
        )
        if (completion)
            job.complete()
        else
            withTimeoutOrNull(3000) {
                job.join()
            }
        return@withContext job.isCompleted
    }