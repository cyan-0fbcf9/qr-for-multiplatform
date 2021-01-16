package classes

class ColorAlpha : Color {
    val alpha: Float

    constructor(red: Int, green: Int, blue: Int, alpha: Float) : super(red, green, blue) {
        this.alpha = alpha
    }

    constructor(rgbHex: Int, alpha: Float) : super(rgbHex) {
        this.alpha = alpha
    }

    constructor(rgbaHex: Long) : super((rgbaHex ushr 8).toInt()) {
        this.alpha = (rgbaHex and 0x000000FF) / 255f
    }

    constructor(color: Color) : super(color.red, color.green, color.blue) {
        this.alpha = 1.0f
    }

    fun toRGBAHex(): Long {
        return (red.toLong() shl 24) + (green shl 16) + (blue shl 8) + (alpha * 255f).toInt()
    }

    fun toBGRAHex(): Long {
        return (blue.toLong() shl 24) + (green shl 16) + (red shl 8) + (alpha * 255f).toInt()
    }

    fun toARGBHex(): Long {
        return ((alpha * 255f).toLong() shl 24) + (red shl 16) + (green shl 8) + (blue)
    }

    fun toABGRHex(): Long {
        return ((alpha * 255f).toLong() shl 24) + (blue shl 16) + (green shl 8) + (red)
    }
}