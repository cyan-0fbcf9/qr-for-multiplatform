@file:Suppress("FunctionName")

package components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import functions.export
import functions.showSaveFileDialog
import java.awt.Frame
import java.awt.image.BufferedImage


@Composable
fun ExportButton(qrImage: State<BufferedImage?>, parentWindow: Frame? = null) {
    Button(
        onClick = {
            val path = showSaveFileDialog(parentWindow) ?: return@Button
            qrImage.value?.let { image -> export(image, path) }
        }
    ) {
        Text("Export")
    }
}