@file:Suppress("FunctionName")

package views

import androidx.compose.ui.window.MenuItem
import components.common.NonSizeWindow
import layout.AppTray
import kotlin.system.exitProcess

fun Root() = NonSizeWindow {
    AppTray(
        MenuItem(
            name = "QR Tool",
            onClick = {
                Main()
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