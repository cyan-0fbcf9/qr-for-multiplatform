package apis

import com.google.common.truth.Truth
import no_test.saveImage
import org.junit.Test

class QRApiTest {
    @Test
    fun testGenerateQr() {
        val generatedImage = QR.generate("https://google.com")
        Truth.assertThat(generatedImage).apply {
            isInstanceOf(ByteArray::class.java)
        }
        saveImage(generatedImage, "testGenerateQr", "png")
    }

    @Test
    fun testGenerateQrWithStackedImage() {
        
    }
}