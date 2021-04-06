@file:Suppress("FunctionName")

package components.qrCodeFacility

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import functions.export
import openSaveDialog
import java.awt.Frame
import java.awt.image.BufferedImage


@Composable
fun ExportButton(qrImage: BufferedImage, parentWindow: Frame? = null) {
    Button(
        onClick = {
            val path = openSaveDialog(parentWindow) ?: return@Button
            export(qrImage, path)
        }
    ) {
        Text("Export")
    }
}