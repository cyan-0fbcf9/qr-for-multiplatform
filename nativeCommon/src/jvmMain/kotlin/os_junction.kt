import javax.imageio.ImageIO

fun <T> osJunction(
    onWindows: (() -> T)? = null,
    onMac: (() -> T)? = null,
    onLinux: (() -> T)? = null,
): T? = when {
    System.getProperty("os.name").toLowerCase().startsWith("win") -> {
        onWindows?.invoke()
    }
    System.getProperty("os.name").toLowerCase().startsWith("mac") -> {
        onMac?.invoke()
    }
    System.getProperty("os.name").toLowerCase().startsWith("linux") -> {
        onLinux?.invoke()
    }
    else -> {
        null
    }
}