package qr

import classes.ColorAlpha
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.client.j2se.MatrixToImageConfig
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import java.awt.image.BufferedImage

class QRGenerator {
    private val writer: QRCodeWriter by lazy {
        QRCodeWriter()
    }

    fun generate(
        value: String,
        size: Int,
        onColor: ColorAlpha = ColorAlpha(0x000000FF),
        offColor: ColorAlpha = ColorAlpha(0xFFFFFFFF)
    ): BufferedImage {
        val bitmap = writer.encode(
            value,
            BarcodeFormat.QR_CODE,
            size,
            size,
            mapOf(
                EncodeHintType.MARGIN to 1,
                EncodeHintType.ERROR_CORRECTION to ErrorCorrectionLevel.Q,
                EncodeHintType.QR_VERSION to 6,
            )
        )
        return MatrixToImageWriter.toBufferedImage(
            bitmap,
            MatrixToImageConfig(onColor.toARGBHex().toInt(), offColor.toARGBHex().toInt())
        )
    }
}