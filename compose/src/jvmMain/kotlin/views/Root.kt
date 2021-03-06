@file:Suppress("FunctionName")

package views

import androidx.compose.ui.window.MenuItem
import app.AppWindows
import components.common.NonSizeWindow
import components.layout.AppTray
import kotlin.system.exitProcess

fun Root() = NonSizeWindow {
    AppTray(
        MenuItem(
            name = "アップデート確認",
            onClick = {
                AppWindows.viewUpdating()
            }
        ),
        MenuItem(
            name = "使い方",
            onClick = {
                AppWindows.viewUsage()
            }
        ),
        // NOTE: いずれ復活させる
//        MenuItem(
//            name = "QR Tool",
//            onClick = {
//                AppWindows.viewQRScreenshot()
//            }
//        ),
        MenuItem(
            name = "終了",
            onClick = {
                exitProcess(0)
            }
        )
    )
}