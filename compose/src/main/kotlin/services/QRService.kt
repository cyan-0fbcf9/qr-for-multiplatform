package services

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import extenstion.duplicate
import extenstion.toByteArray
import logics.graphics.RenderingLogic
import logics.graphics.TransformationLogic
import org.jetbrains.skija.Image
import qr.QRGenerator
import java.awt.image.BufferedImage

class QRService {
    private val generator = QRGenerator()
    private val renderingLogic = RenderingLogic()
    private val transformationLogic = TransformationLogic()

    fun generate(value: String, size: Int): ImageBitmap {
        val byteImg = generator.generate(value, size).toByteArray()
        val skijaImage = Image.makeFromEncoded(byteImg)
        return skijaImage.asImageBitmap()
    }

    suspend fun generate(value: String, stackedImage: BufferedImage, size: Int): ImageBitmap {
        val qrImage = generator.generate(value, size).duplicate(BufferedImage.TYPE_4BYTE_ABGR)
        renderingLogic.stackImageOnCenter(
            baseImage = qrImage,
            stackedImage = transformationLogic.resize(stackedImage, (size * 0.2).toInt())
        )
        val skijaImage = Image.makeFromEncoded(qrImage.toByteArray())
        return skijaImage.asImageBitmap()
    }
}
