@file:Suppress("FunctionName")

package components.qrCodeScanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import components.qrCodeScanner.child.ScannedText
import components.common.SelectImageButton
import components.common.WarningDialog
import components.common.WarningDialogInfo
import singleton.QR
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.image.BufferedImage

@Composable
fun QRCodeScanner() {
    val targetImageState: MutableState<BufferedImage?> = remember { mutableStateOf(null) }
    val scannedTextState: MutableState<String> = remember { mutableStateOf("QRコードを選択してください") }
    val warningDialogState: MutableState<WarningDialogInfo?> = remember { mutableStateOf(null) }

    val scanImage: (BufferedImage) -> Unit = { image ->
        targetImageState.value = image
        runCatching {
            QR.scan(image)
        }.fold(
            onSuccess = { scannedText ->
                scannedTextState.value = scannedText
            },
            onFailure = {
                warningDialogState.value = WarningDialogInfo(
                    title = "警告",
                    message = "画像を読み取れません",
                    onAction = {
                        warningDialogState.value = null
                    }
                )
            }
        )
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        ScannedText(scannedTextState.value)
        SelectImageButton(title = "画像を選択") { image ->
            scanImage(image)
        }
        Button(onClick = {
            try {
                val image = Toolkit.getDefaultToolkit().systemClipboard.getData(DataFlavor.imageFlavor) as BufferedImage
                scanImage(image)
                Toolkit.getDefaultToolkit().systemClipboard.apply {
                    addFlavorListener {
                        println(this.getData(DataFlavor.stringFlavor) as String)
                    }
                }
            } catch (e: Exception) {
                warningDialogState.value = WarningDialogInfo(
                    title = "警告",
                    message = "クリップボードのデータを読み取れません",
                    onAction = {
                        warningDialogState.value = null
                    }
                )
            }
        }) {
            Text("クリップボードから")
        }
        /**
         * Dialog
         */
        warningDialogState.value?.let {
            WarningDialog(it)
        }
    }
}
