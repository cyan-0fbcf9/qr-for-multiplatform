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
import components.qrCodeScanner.child.ScannedText
import components.SelectImageButton
import singleton.QR
import java.awt.image.BufferedImage
import java.lang.reflect.Executable

@Composable
fun QRCodeScanner() {
    val targetImage: MutableState<BufferedImage?> = remember { mutableStateOf(null) }
    val scannedText: MutableState<String> = remember { mutableStateOf("QRコードを選択してください") }
    val warningDialogState: MutableState<Boolean> = remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        ScannedText(scannedText.value)
        SelectImageButton(
            title = "画像を選択"
        ) { image ->
            targetImage.value = image
            kotlin.runCatching {
                QR.scan(image)
            }.fold(
                onSuccess = {
                    scannedText.value = it
                },
                onFailure = {
                    warningDialogState.value = true
                }
            )
        }
//    TODO("クリップボードからの選択")
        /**
         * Dialog
         */
        if (warningDialogState.value) {
            AlertDialog(
                onDismissRequest = {
                    warningDialogState.value = false
                },
                confirmButton = {
                    Button(onClick = {
                        warningDialogState.value = false
                    }) {
                        Text("OK")
                    }
                },
                title = { Text("title") },
                text = { Text("text") }
            )
        }
    }
}
