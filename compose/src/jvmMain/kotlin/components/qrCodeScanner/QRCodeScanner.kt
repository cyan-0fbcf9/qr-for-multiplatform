@file:Suppress("FunctionName")

package components.qrCodeScanner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.AmbientClipboardManager
import components.qrCodeScanner.child.ScannedText
import components.SelectImageButton
import components.common.WarningDialog
import components.common.WarningDialogInfo
import singleton.QR
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.UnsupportedFlavorException
import java.awt.image.BufferedImage
import java.lang.reflect.Executable

@Composable
fun QRCodeScanner() {
    val targetImage: MutableState<BufferedImage?> = remember { mutableStateOf(null) }
    val scannedText: MutableState<String> = remember { mutableStateOf("QRコードを選択してください") }
    val warningDialogState: MutableState<WarningDialogInfo?> = remember { mutableStateOf(null) }

    val scanImage: (BufferedImage) -> Unit = {
        runCatching {
            QR.scan(it)
        }.fold(
            onSuccess = {
                scannedText.value = it
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
        ScannedText(scannedText.value)
        SelectImageButton(title = "画像を選択") { image ->
            scanImage(image)
        }
        Button(onClick = {
            try {
                val image = Toolkit.getDefaultToolkit().systemClipboard.getData(DataFlavor.imageFlavor) as BufferedImage
                scanImage(image)
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
