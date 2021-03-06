package apis

import extenstion.duplicate
import extenstion.toByteArray
import logics.graphics.resize
import logics.graphics.stackImageOnCenter
import qr.QRGenerator
import services.HttpService
import java.awt.image.BufferedImage

object QR {
    private const val DEFAULT_IMAGE_SIZE = 512
    private val qrGenerator: QRGenerator = QRGenerator()

    fun generate(value: String): ByteArray {
        val qrImage = qrGenerator.generate(value, DEFAULT_IMAGE_SIZE)
        return qrImage.toByteArray("png")
    }

    suspend fun generate(value: String, stackedImageUrl: String): ByteArray {
        val imageType = BufferedImage.TYPE_4BYTE_ABGR
        val stackedImage =
            HttpService.downloadImage(stackedImageUrl)?.duplicate(specificationType = imageType)
                ?: throw NullPointerException("returned null")
        val qrImage =
            qrGenerator.generate(value, DEFAULT_IMAGE_SIZE).duplicate(specificationType = imageType)
        stackImageOnCenter(
            baseImage = qrImage,
            stackedImage = resize(
                stackedImage,
                (DEFAULT_IMAGE_SIZE * 0.2).toInt()
            )
        )
        return qrImage.toByteArray("png")
    }
}
