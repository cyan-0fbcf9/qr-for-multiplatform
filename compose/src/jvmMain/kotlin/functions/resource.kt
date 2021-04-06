package functions

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

fun getIcon(): BufferedImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/icon.png"))

fun getTrayIcon(): BufferedImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/tray icon.png"))