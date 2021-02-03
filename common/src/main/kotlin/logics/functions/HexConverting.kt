package logics.functions

import extenstion.toHexInt
import kotlin.math.pow

/**
 * @throws NullPointerException
 */
fun hexToInt(hexString: String): Int {
    var resultValue = 0
    val checkedValue = hexString.replace("0x", "")
    checkedValue
        .forEachIndexed { index, it ->
            val hexValue = it.toHexInt() ?: throw NullPointerException()
            resultValue += hexValue * 16.0.pow((checkedValue.length - (index + 1)).toDouble()).toInt()
        }
    return resultValue
}