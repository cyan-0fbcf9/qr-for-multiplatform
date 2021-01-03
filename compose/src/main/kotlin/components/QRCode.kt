@file:Suppress("FunctionName")

package components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import extentions.asImageBitmap
import services.QRService
import java.awt.image.BufferedImage

@Composable
fun QRCode(value: String, size: Int = 512) {
    val qrService = QRService()
    val qrImage = remember { mutableStateOf<BufferedImage?>(null) }
    LaunchedEffect(null) {
        qrImage.value = qrService.generate(value, size)
    }
    qrImage.value?.let { image ->
        Image(image.asImageBitmap())
    }
}