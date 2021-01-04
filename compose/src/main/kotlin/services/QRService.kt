package services

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
        stackedImage: BufferedImage? = null
    ): BufferedImage {
        val qrImage = generator.generate(value, size).duplicate(BufferedImage.TYPE_4BYTE_ABGR)
        stackedImage?.apply {
            renderingLogic.stackImageOnCenter(
                baseImage = qrImage,
                stackedImage = transformationLogic.resize(this, (size * 0.2).toInt())
            )
        }
        return qrImage
    }
}
