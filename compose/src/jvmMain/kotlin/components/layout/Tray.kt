@file:Suppress("FunctionName")

package components.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.MenuItem
import androidx.compose.ui.window.Tray
import functions.getTrayIcon
import static.APP_NAME
import javax.imageio.ImageIO

@Composable
fun AppTray(vararg menuItems: MenuItem) {
    Tray(image = getTrayIcon(), tooltip = APP_NAME).apply {
        menu(*menuItems)
    }
}