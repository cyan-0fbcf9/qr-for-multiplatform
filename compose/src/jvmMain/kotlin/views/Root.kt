@file:Suppress("FunctionName")

package views

import androidx.compose.ui.window.MenuItem
import components.common.NonSizeWindow
import components.layout.AppTray
import app.AppWindows
import kotlin.system.exitProcess

fun Root() = NonSizeWindow {
    AppTray(
        MenuItem(
            name = "Usage",
            onClick = {
                AppWindows.viewUsage()
            }
        ),
        MenuItem(
            name = "QR Tool",
            onClick = {
                AppWindows.viewQRScreenshot()
            }
        ),
        MenuItem(
            name = "Exit",
            onClick = {
                exitProcess(0)
            }
        )
    )
}