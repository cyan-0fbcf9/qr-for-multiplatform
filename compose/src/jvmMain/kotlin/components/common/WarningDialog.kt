@file:Suppress("FunctionName")

package components.common

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun WarningDialog(info: WarningDialogInfo) {
    AlertDialog(
        onDismissRequest = info.onAction,
        confirmButton = {
            Button(onClick = info.onAction) {
                Text("OK")
            }
        },
        title = { Text(info.title) },
        text = { Text(info.message) }
    )
}

data class WarningDialogInfo(val title:  String, val message: String, val onAction: () -> Unit)
