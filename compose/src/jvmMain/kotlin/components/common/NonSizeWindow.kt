@file:Suppress("FunctionName")

package components.common

import androidx.compose.desktop.AppManager
import androidx.compose.desktop.Window
import androidx.compose.desktop.WindowEvents
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntSize

fun NonSizeWindow(content: @Composable () -> Unit) {
    Window(
        size = IntSize.Zero,
        events = WindowEvents(
            onOpen = {
                AppManager.exit()
            }
        ),
        undecorated = true
    ) {
        content()
    }
}