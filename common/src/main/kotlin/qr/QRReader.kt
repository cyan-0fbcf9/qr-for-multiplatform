package qr

import com.google.zxing.BarcodeFormat
import com.google.zxing.BinaryBitmap
import com.google.zxing.DecodeHintType
import com.google.zxing.Reader
import com.google.zxing.client.j2se.BufferedImageLuminanceSource
import com.google.zxing.common.HybridBinarizer
import com.google.zxing.qrcode.QRCodeReader
import java.awt.image.BufferedImage

class QRReader {
    private val reader: Reader by lazy {
        QRCodeReader()
    }

    private val decodeHintTypes: Map<DecodeHintType, Any> = mapOf(
        DecodeHintType.POSSIBLE_FORMATS to listOf(BarcodeFormat.QR_CODE),
    )

    @Throws(Exception::class)
    fun read(bitmap: BinaryBitmap): String {
        val result = this.reader.decode(bitmap, this.decodeHintTypes)
        return result.text
    }

    @Throws(Exception::class)
    fun read(bufImage: BufferedImage): String {
        val bitmap = BinaryBitmap(HybridBinarizer(BufferedImageLuminanceSource(bufImage)))
        return this.read(bitmap)
    }
}