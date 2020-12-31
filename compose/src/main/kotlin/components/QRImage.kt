@file:Suppress("FunctionName")

package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import extenstion.duplicate
import services.QRService
import java.awt.image.BufferedImage

@Composable
fun QRImage(value: String, size: Int = 512) {
    val qrService = QRService()
    Image(qrService.generate(value, size))
}

@Composable
fun QRImage(value: String, stackedImage: BufferedImage, size: Int = 512) {
    val qrService = QRService()
    val qrImage = remember { mutableStateOf<ImageBitmap?>(null) }
    LaunchedEffect(null) {
        qrImage.value =
            qrService.generate(
                value,
                stackedImage.duplicate(BufferedImage.TYPE_4BYTE_ABGR),
                size
            )
    }
    qrImage.value?.let {
        Image(it, Modifier.size(512.dp, 512.dp))
    }
}