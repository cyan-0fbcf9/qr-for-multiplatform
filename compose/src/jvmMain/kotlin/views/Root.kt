@file:Suppress("FunctionName")

package views

import androidx.compose.desktop.AppManager
import androidx.compose.ui.window.MenuItem
import components.common.NonSizeWindow
import components.layout.AppTray
import extentions.toTop
import java.awt.Frame
import kotlin.system.exitProcess

fun Root() = NonSizeWindow {
    AppTray(
        MenuItem(
            name = "QR Tool",
            onClick = {
                val appFrame = AppManager.windows.firstOrNull()
                if (appFrame == null) {
                    Main()
                } else {
                    if (appFrame.window.state == Frame.ICONIFIED) {
                        appFrame.window.state = Frame.NORMAL
                    }
                    appFrame.window.toTop()
                }
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