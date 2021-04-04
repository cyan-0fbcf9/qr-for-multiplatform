@file:Suppress("FunctionName")

package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import singleton.QR
import java.awt.image.BufferedImage
import javax.swing.GroupLayout

@Composable
fun QRCodeScanner() {
    val targetImage: MutableState<BufferedImage?> = remember { mutableStateOf(null) }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        targetImage.value?.let {
            ScannedText(QR.scan(it))
        }
        SelectImageButton { image ->
            targetImage.value = image
        }
//    TODO("クリップボードからの選択")
    }
}
