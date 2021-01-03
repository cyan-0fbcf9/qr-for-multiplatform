import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import components.QRCodePresentation
import javax.imageio.ImageIO

fun main() = Window(
    size = IntSize(1200, 700)
) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            QRCodePresentation(
                value = "https://cyan-0fbcf9.com",
                size = 512,
                stackedImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/vue.png"))
            )
        }
    }
}