package classes

import com.google.common.truth.Truth
import org.junit.Test

class ColorTest {
    @Test
    fun testSimpleColor() {
        val testValue = 0xF0F0F0
        val color = Color(testValue)
        Truth.assertThat(color.red).isEqualTo(0xF0)
        Truth.assertThat(color.green).isEqualTo(0xF0)
        Truth.assertThat(color.blue).isEqualTo(0xF0)
    }

    @Test
    fun testToHexFunction() {
        val red = 0x30
        val green = 0x50
        val blue = 0x70
        val color = Color(red, green, blue)
        Truth.assertThat(color.toRGBHex()).isEqualTo(0x305070)
        Truth.assertThat(color.toBGRHex()).isEqualTo(0x705030)

        val alpha = 0xFF
        val colorAlpha = ColorAlpha(red, green, blue, alpha / 255f)
        Truth.assertThat(colorAlpha.toRGBAHex().toInt()).isEqualTo(0x305070FF)
        Truth.assertThat(colorAlpha.toBGRAHex().toInt()).isEqualTo(0x705030FF)
        Truth.assertThat(colorAlpha.toARGBHex()).isEqualTo(0xFF305070)
        Truth.assertThat(colorAlpha.toABGRHex()).isEqualTo(0xFF705030)

        val colorAlpha2 = ColorAlpha((red.toLong() shl 24) + (green shl 16) + (blue shl 8) + alpha)
        Truth.assertThat(colorAlpha2.toRGBAHex().toInt()).isEqualTo(0x305070FF)
        Truth.assertThat(colorAlpha2.toBGRAHex().toInt()).isEqualTo(0x705030FF)
        Truth.assertThat(colorAlpha2.toARGBHex()).isEqualTo(0xFF305070)
        Truth.assertThat(colorAlpha2.toABGRHex()).isEqualTo(0xFF705030)
    }
}