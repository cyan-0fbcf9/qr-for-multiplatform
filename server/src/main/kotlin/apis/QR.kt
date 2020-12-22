package apis

import qr.QRGenerator
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

object QR {
    private val qrGenerator: QRGenerator = QRGenerator()

    fun generate(value: String): ByteArray {
        val qrImage = qrGenerator.generate(value, 512)
        return ByteArrayOutputStream().apply {
            ImageIO.write(qrImage, "png", this)
        }.toByteArray()
    }
}
