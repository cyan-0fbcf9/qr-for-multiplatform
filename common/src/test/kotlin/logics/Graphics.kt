package logics

import com.google.common.truth.Truth
import extenstion.toByteArray
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import logics.graphics.stackImageOnCenter
import org.junit.Test
import javax.imageio.ImageIO

class Graphics {
    @Test
    fun testCommonStackImageOnCenterMethod() {
        val baseImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("base.png"))
        val stackImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("stack.png"))
        runBlocking {
            Truth.assertThat(stackImageOnCenter(baseImage, stackImage)).apply {
                isTrue()
            }
        }
    }

    @Test
    fun testBufferedImageToByteArray() {
        val baseImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("base.png"))
        Truth.assertThat(baseImage.toByteArray()).apply {
            isInstanceOf(ByteArray::class.java)
        }
    }
}