@file:Suppress("FunctionName")

package components

import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import classes.Color
import extenstion.duplicate
import extentions.asImageBitmap
import singleton.QR
import java.awt.image.BufferedImage

@Composable
fun QRCodeFacility(
    value: String,
    size: Int = 512,
    onColor: Color = Color(0x000000),
    offColor: Color = Color(0xFFFFFF),
) {
    val qrImage = remember { mutableStateOf<BufferedImage?>(null) }
    val stackedImage = remember { mutableStateOf<BufferedImage?>(null) }
    LaunchedEffect(stackedImage.value) {
        qrImage.value =
            QR.generate(
                value,
                size,
                stackedImage.value?.duplicate(BufferedImage.TYPE_4BYTE_ABGR),
                onColor,
                offColor
            )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        qrImage.value?.let { qrImage -> Image(qrImage.asImageBitmap(), Modifier.size(size.dp)) }
        SelectImageButton(stackedImage = stackedImage)
        ExportButton(qrImage, AppWindowAmbient.current?.window)
    }
}
