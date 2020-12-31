package logics

import com.google.common.truth.Truth
import extenstion.toByteArray
import kotlinx.coroutines.runBlocking
import logics.graphics.RenderingLogic
import org.junit.Test
import javax.imageio.ImageIO

class GraphicsTest {
    @Test
    fun testStackImageOnCenterMethod(): Unit = runBlocking {
        val renderingLogics = RenderingLogic()
        val baseImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("base.png"))
        val stackImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("stack.png"))
        val result = renderingLogics.stackImageOnCenter(baseImage, stackImage)
        Truth.assertThat(result).apply {
            isTrue()
        }
    }

    @Test
    fun testBufferedImageToByteArray() {
        val baseImage =
            ImageIO.read(ClassLoader.getSystemResourceAsStream("base.png"))
        Truth.assertThat(baseImage.toByteArray()).apply {
            isInstanceOf(ByteArray::class.java)
        }
    }
}