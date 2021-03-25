package qr

import com.google.common.truth.Truth
import com.google.zxing.NotFoundException
import org.junit.Test
import javax.imageio.ImageIO

class QRReaderTest {
    /**
     * BufferedImageのQRコードが読み込めるかのテスト
     */
    @Test
    fun testIsBufferedImageAbleToRead() {
        val qrImageStream = ClassLoader.getSystemResourceAsStream("qr.png")
        val qrImage = ImageIO.read(qrImageStream)
        val qrReader = QRReader()
        Truth.assertThat(qrReader.read(qrImage)).isEqualTo("https://google.com")
    }

    /**
     * QRコードじゃない画像を読み込んだ時のテスト
     */
    @Test
    fun testReadingExceptions() {
        val fakeImageStream = ClassLoader.getSystemResourceAsStream("stack.png")
        val fakeImage = ImageIO.read(fakeImageStream)
        val qrReader = QRReader()
        try {
            qrReader.read(fakeImage)
        } catch (e: Exception) {
            Truth.assertThat(e).apply {
                isInstanceOf(NotFoundException::class.java)
            }
        }
    }
}
