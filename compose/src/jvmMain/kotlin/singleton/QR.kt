package singleton

import classes.Color
import classes.ColorAlpha
import extenstion.duplicate
import logics.graphics.resize
import logics.graphics.stackImageOnCenter
import qr.QRGenerator
import qr.QRReader
import java.awt.image.BufferedImage

object QR {
    private val generator = QRGenerator()
    private val scanner = QRReader()

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
            stackImageOnCenter(
                baseImage = qrImage,
                stackedImage = resize(this, (size * 0.2).toInt())
            )
        }
        return qrImage
    }

    @Throws(Exception::class)
    fun scan(image: BufferedImage): String = this.scanner.read(image)
}