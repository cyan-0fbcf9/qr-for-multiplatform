@file:Suppress("FunctionName")

package components

import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import classes.Color
import extenstion.duplicate
import extentions.asImageBitmap
import kotlinx.coroutines.launch
import singleton.QR
import java.awt.image.BufferedImage

@Composable
fun QRCodeFacility(
    value: String,
    size: Int = 512,
    onColor: Color = Color(0x000000),
    offColor: Color = Color(0xFFFFFF),
) {
    val scope = rememberCoroutineScope()
    val qrImage = remember { mutableStateOf<BufferedImage?>(null) }

    // initialize
    if (qrImage.value == null) {
        scope.launch {
            qrImage.value = QR.generate(
                value,
                size,
                null,
                onColor,
                offColor
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        qrImage.value?.let {
            Image(it.asImageBitmap(), Modifier.size(size.dp))
            SelectImageButton(
                "重ねる画像を選択"
            ) { selectedImage ->
                scope.launch {
                    qrImage.value =
                        QR.generate(
                            value,
                            size,
                            selectedImage.duplicate(BufferedImage.TYPE_4BYTE_ABGR),
                            onColor,
                            offColor
                        )
                }
            }
            ExportButton(it, AppWindowAmbient.current?.window)
        }
    }
}
