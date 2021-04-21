package app

import osJunction
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

object AppResource {
    val AppIcon: BufferedImage
        get() {
            val image = osJunction<BufferedImage>(
                onWindows = {
                    ImageIO.read(ClassLoader.getSystemResourceAsStream("assets/icon/common/icon.png"))
                },
                onMac = {
                    ImageIO.read(ClassLoader.getSystemResourceAsStream("assets/icon/macos/icon.png"))
                },
                onLinux = {
                    ImageIO.read(ClassLoader.getSystemResourceAsStream("assets/icon/common/icon.png"))
                })
            return image ?: throw NullPointerException()
        }

    val TrayIcon: BufferedImage
        get() {
            val image = osJunction<BufferedImage>(
                onWindows = {
                    ImageIO.read(ClassLoader.getSystemResourceAsStream("assets/images/tray icon.png"))
                },
                onMac = {
                    ImageIO.read(ClassLoader.getSystemResourceAsStream("assets/images/tray icon for mac.png"))
                },
                onLinux = {
                    ImageIO.read(ClassLoader.getSystemResourceAsStream("assets/images/tray icon.png"))
                }
            )
            return image ?: throw NullPointerException()
        }
}