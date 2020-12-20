package components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import services.QRService

@Composable
fun QRImage(url: String) {
    val qrService = QRService()
    Image(qrService.bitmap(url))
}