package services

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import extenstion.toByteArray
import org.jetbrains.skija.Image
import qr.QRGenerator

class QRService {
    private val generator = QRGenerator()

    fun bitmap(value: String, size: Int = 512): ImageBitmap {
        val byteImg = generator.generate(value, size).toByteArray()
        val skijaImage = Image.makeFromEncoded(byteImg)
        return skijaImage.asImageBitmap()
    }
}
