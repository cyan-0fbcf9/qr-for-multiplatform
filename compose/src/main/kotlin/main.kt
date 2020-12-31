import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import components.QRImage
import services.QRService
import javax.imageio.ImageIO

fun main() = Window(
    size = IntSize(800, 500)
) {
    val qrService = QRService()

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            QRImage(
                value = "https://cyan-0fbcf9.com",
                ImageIO.read(ClassLoader.getSystemResourceAsStream("images/vue.png"))
            )
        }
    }
}