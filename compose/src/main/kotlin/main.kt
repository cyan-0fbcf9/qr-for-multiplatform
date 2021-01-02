import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import components.QRImage
import services.DialogService
import services.ImageIOService
import javax.imageio.ImageIO

fun main() = Window(
    size = IntSize(1200, 700)
) {
    val dialogService = DialogService(AppWindowAmbient.current?.window)
    val imageIOService = ImageIOService()

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val bufferedImage =
                ImageIO.read(ClassLoader.getSystemResourceAsStream("images/vue.png"))
            QRImage(
                value = "https://cyan-0fbcf9.com",
                bufferedImage
            )
            Row(horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        println(dialogService.showSelectFileDialog())
                    }) {
                    Text("Select Image")
                }
                Spacer(Modifier.preferredSize(10.dp))
                Button(
                    onClick = {
                        dialogService.showSaveFileDialog()?.also { path ->
                            imageIOService.export(bufferedImage, path)
                        }
                    }
                ) {
                    Text("Export")
                }
            }
        }
    }
}