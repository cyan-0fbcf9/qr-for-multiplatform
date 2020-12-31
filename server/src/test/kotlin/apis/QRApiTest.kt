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
            stackedImageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Kotlin-logo.svg/1200px-Kotlin-logo.svg.png"
        )
        Truth.assertThat(generatedImage).apply {
            isInstanceOf(ByteArray::class.java)
        }
        saveImage(generatedImage, QRApiTest::testGenerateQrWithStackedImage.toString(), "png")
    }
}