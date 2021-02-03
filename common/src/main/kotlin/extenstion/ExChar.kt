package extenstion

fun Char.toHexInt(): Int? =
    this.toUpperCase().takeUnless {
        it.toInt() in ':'.toInt()..'@'.toInt() || it.toInt() in 'G'.toInt()..'Z'.toInt()
    }?.let {
        if (it.toInt() / 'A'.toInt() == 0) {
            it.toInt() - '0'.toInt()
        } else {
            it.toInt() - 'A'.toInt() + 10
        }
    }