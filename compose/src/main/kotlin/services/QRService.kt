package services

import classes.Color
import classes.ColorAlpha
import extenstion.duplicate
import logics.graphics.RenderingLogic
import logics.graphics.TransformationLogic
import qr.QRGenerator
import java.awt.image.BufferedImage

class QRService {
    private val generator = QRGenerator()
    private val renderingLogic = RenderingLogic()
    private val transformationLogic = TransformationLogic()

    suspend fun generate(
        value: String,
        size: Int,
        stackedImage: BufferedImage? = null,
        onColor: Color = Color(0x000000),
        offColor: Color = Color(0xFFFFFF)
    ): BufferedImage {
        val qrImage = generator.generate(value, size, ColorAlpha(onColor), ColorAlpha(offColor))
            .duplicate(BufferedImage.TYPE_4BYTE_ABGR)
        stackedImage?.apply {
            renderingLogic.stackImageOnCenter(
                baseImage = qrImage,
                stackedImage = transformationLogic.resize(this, (size * 0.2).toInt())
            )
        }
        return qrImage
    }
}
