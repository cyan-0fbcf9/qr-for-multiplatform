@file:Suppress("FunctionName")

package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import services.DialogService
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

@Composable
fun QRCodeFacility() {
    val dialogService = DialogService()
    val stackedImage = remember { mutableStateOf<BufferedImage?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        QRCodePresentation(
            value = "https://cyan-0fbcf9.com",
            size = 512,
            stackedImage = stackedImage.value
        )
        Button(
            onClick = {
                val path = dialogService.showSelectFileDialog() ?: return@Button
                stackedImage.value = ImageIO.read(File(path))
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Select Stacked Image")
        }
    }
}