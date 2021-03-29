@file:Suppress("FunctionName")

package components

import androidx.compose.desktop.AppManager
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import openSelectDialog
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

@Composable
fun SelectImageButton(
    onSelected: (BufferedImage) -> Unit
) {
    Button(
        onClick = {
            val path = openSelectDialog(AppManager.focusedWindow?.window) ?: return@Button
            onSelected(ImageIO.read(File(path)))
        },
        modifier = Modifier.padding(10.dp)
    ) {
        Text("Select Stacked Image")
    }
}
