package apis

import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import no_test.saveImage
import org.junit.Test

class QRApiTest {
    @Test
    fun testGenerateQr() {
        val generatedImage = QR.generate("https://google.com")
        Truth.assertThat(generatedImage).apply {
            isInstanceOf(ByteArray::class.java)
        }
        saveImage(generatedImage, QRApiTest::testGenerateQr.toString(), "png")
    }

    @Test
    fun testGenerateQrWithStackedImage(): Unit = runBlocking {
        val generatedImage = QR.generate(
            value = "https://google.com",
            stackedImageUrl = "https://firebasestorage.googleapis.com/v0/b/free-experimental.appspot.com/o/public%2Fcyan-icon-v2.png?alt=media&token=d7979d25-f179-48df-907e-cc3edcb42864"
        )
        Truth.assertThat(generatedImage).apply {
            isInstanceOf(ByteArray::class.java)
        }
        saveImage(generatedImage, QRApiTest::testGenerateQrWithStackedImage.toString(), "png")
    }
}