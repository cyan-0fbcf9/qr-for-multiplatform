package qr

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import java.awt.image.BufferedImage

class QRGenerator {
    private val writer: QRCodeWriter = QRCodeWriter()

    fun generate(value: String, size: Int): BufferedImage {
        val bitmap = writer.encode(value, BarcodeFormat.QR_CODE, size, size)
        return MatrixToImageWriter.toBufferedImage(bitmap)
    }
}