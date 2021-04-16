package app

import osJunction
import java.awt.image.BufferedImage
import java.lang.NullPointerException
import javax.imageio.ImageIO

object AppResource {
    val AppIcon: BufferedImage get() = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/icon.png"))

    val TrayIcon: BufferedImage
        get() {
            val image = osJunction<BufferedImage>(
                onWindows = {
                    ImageIO.read(ClassLoader.getSystemResourceAsStream("images/tray icon.png"))
                },
                onMac = {
                    ImageIO.read(ClassLoader.getSystemResourceAsStream("images/tray icon for mac.png"))
                },
                onLinux = {
                    ImageIO.read(ClassLoader.getSystemResourceAsStream("images/tray icon.png"))
                }
            )
            return image ?: throw NullPointerException()
        }
}