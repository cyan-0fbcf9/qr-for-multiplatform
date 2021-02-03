package logics

import classes.ColorAlpha
import com.google.common.truth.Truth
import logics.functions.hexToInt
import org.junit.Test

class HexConvertingTest {
    @Test
    fun testHexTypeStringToInt() {
        val rightValue = 0xFD321A
        val testValue = "0xFD321A"
        Truth.assertThat(hexToInt(testValue)).isEqualTo(rightValue)
    }
}