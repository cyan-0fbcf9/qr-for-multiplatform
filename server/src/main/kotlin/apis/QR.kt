package apis

import classes.ColorAlpha
import extenstion.duplicate
import extenstion.toByteArray
import logics.graphics.RenderingLogic
import logics.graphics.TransformationLogic
import qr.QRGenerator
import services.HttpService
import java.awt.image.BufferedImage

object QR {
    private const val DEFAULT_IMAGE_SIZE = 512
    private val qrGenerator: QRGenerator = QRGenerator()
    private val renderingLogic: RenderingLogic = RenderingLogic()
    private val transformationLogic: TransformationLogic = TransformationLogic()

    fun generate(
        value: String,
        onColor: ColorAlpha = ColorAlpha(0x000000FF),
        offColor: ColorAlpha = ColorAlpha(0xFFFFFFFFF)
    ): ByteArray {
        val qrImage = qrGenerator.generate(value, DEFAULT_IMAGE_SIZE, onColor, offColor)
        return qrImage.toByteArray("png")
    }

    suspend fun generate(
        value: String,
        stackedImageUrl: String,
        onColor: ColorAlpha = ColorAlpha(0x000000FF),
        offColor: ColorAlpha = ColorAlpha(0xFFFFFFFFF)
    ): ByteArray {
        val imageType = BufferedImage.TYPE_4BYTE_ABGR
        val stackedImage =
            HttpService.downloadImage(stackedImageUrl)?.duplicate(specificationType = imageType)
                ?: throw NullPointerException("returned null")
        val qrImage =
            qrGenerator.generate(
                value,
                DEFAULT_IMAGE_SIZE,
                onColor,
                offColor
            ).duplicate(specificationType = imageType)
        renderingLogic.stackImageOnCenter(
            baseImage = qrImage,
            stackedImage = transformationLogic.resize(
                stackedImage,
                (DEFAULT_IMAGE_SIZE * 0.2).toInt()
            )
        )
        return qrImage.toByteArray("png")
    }
}
