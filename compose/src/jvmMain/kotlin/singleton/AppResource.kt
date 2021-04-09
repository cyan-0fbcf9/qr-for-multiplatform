package singleton

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

object AppResource {
    val AppIcon: BufferedImage get() = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/icon.png"))

    val TrayIcon: BufferedImage get() = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/tray icon.png"))
}