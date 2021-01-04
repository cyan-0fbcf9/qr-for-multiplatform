package extentions

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import extenstion.toByteArray
import org.jetbrains.skija.Image
import java.awt.image.BufferedImage

fun BufferedImage.asImageBitmap(): ImageBitmap {
    val image = Image.makeFromEncoded(this.toByteArray())
    return image.asImageBitmap()
}