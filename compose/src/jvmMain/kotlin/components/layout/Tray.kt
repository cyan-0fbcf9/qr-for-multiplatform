@file:Suppress("FunctionName")

package components.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.MenuItem
import androidx.compose.ui.window.Tray
import modules.singleton.AppResource
import static.APP_NAME

@Composable
fun AppTray(vararg menuItems: MenuItem) {
    Tray(image = AppResource.TrayIcon, tooltip = APP_NAME).apply {
        menu(*menuItems)
    }
}