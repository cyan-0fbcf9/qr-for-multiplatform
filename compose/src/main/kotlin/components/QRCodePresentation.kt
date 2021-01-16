@file:Suppress("FunctionName")

package components

import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import classes.Color
import extenstion.duplicate
import extentions.asImageBitmap
import services.DialogService
import services.ImageIOService
import services.QRService
import java.awt.image.BufferedImage

@Composable
fun QRCodePresentation(
    value: String,
    size: Int = 512,
    stackedImage: BufferedImage? = null,
    onColor: Color = Color(0x000000),
    offColor: Color = Color(0xFFFFFF),
    exportable: Boolean = true
) {
    val qrService = QRService()
    val qrImage = remember { mutableStateOf<BufferedImage?>(null) }
    LaunchedEffect(stackedImage) {
        qrImage.value =
            qrService.generate(
                value,
                size,
                stackedImage?.duplicate(BufferedImage.TYPE_4BYTE_ABGR),
                onColor,
                offColor
            )
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        qrImage.value?.let { qrImage ->
            Image(qrImage.asImageBitmap(), Modifier.size(size.dp))
        }
        if (exportable) {
            ExportButton(qrImage)
        }
    }
}

@Composable
fun ExportButton(qrImage: State<BufferedImage?>) {
    val dialogService = DialogService(AppWindowAmbient.current?.window)
    val imageIOService = ImageIOService()

    Button(
        onClick = {
            val path = dialogService.showSaveFileDialog() ?: return@Button
            qrImage.value?.let { image ->
                imageIOService.export(image, path)
            }
        }
    ) {
        Text("Export")
    }
}