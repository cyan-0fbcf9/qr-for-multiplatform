package classes

import logics.functions.hexToInt

open class Color : Colorable {
    val red: Int
    val green: Int
    val blue: Int

    constructor(red: Int, green: Int, blue: Int) {
        this.red = red
        this.green = green
        this.blue = blue
    }

    constructor(hex: Int) {
        this.red = (hex and 0xFF0000) ushr 16
        this.green = (hex and 0x00FF00) ushr 8
        this.blue = hex and 0x0000FF
    }

    constructor(hexString: String) {
        val hex = try {
            hexToInt(hexString)
        } catch (e: NullPointerException) {
            0
        }
        this.red = (hex and 0xFF0000) ushr 16
        this.green = (hex and 0x00FF00) ushr 8
        this.blue = hex and 0x0000FF
    }

    override fun toRGBHex(): Int {
        return (red shl 16) + (green shl 8) + (blue)
    }

    override fun toBGRHex(): Int {
        return (blue shl 16) + (green shl 8) + (red)
    }
}