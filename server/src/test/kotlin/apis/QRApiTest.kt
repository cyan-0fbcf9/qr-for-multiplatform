package apis

import com.google.common.truth.Truth
import org.junit.Test
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import javax.imageio.ImageIO

class QRApiTest {
    @Test
    fun testGenerateQr() {
        val generatedImage = QR.generate("https://google.com")
        Truth.assertThat(generatedImage).apply {
            isInstanceOf(ByteArray::class.java)
        }
        FileOutputStream("src/test/resources/outputs/testGenerateQr.png").apply {
            write(generatedImage)
            close()
        }
    }

    @Test
    fun testGenerateQrWithStackedImage() {

    }
}