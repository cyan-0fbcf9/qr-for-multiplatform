@file:Suppress("FunctionName")

package layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.MenuItem
import androidx.compose.ui.window.Tray
import static.APP_NAME
import javax.imageio.ImageIO
import kotlin.system.exitProcess

@Composable
fun AppTray(vararg menuItems: MenuItem) {
    Tray(image = ImageIO.read(ClassLoader.getSystemResourceAsStream("images/vue.png")), tooltip = APP_NAME).apply {
        menu(*menuItems)
    }
}