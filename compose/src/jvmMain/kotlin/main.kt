import androidx.compose.desktop.AppManager
import androidx.compose.desktop.Window
import androidx.compose.desktop.WindowEvents
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.MenuItem
import functions.setClipboardListener
import layout.AppTray
import views.Main
import views.Root
import java.awt.PopupMenu
import java.awt.SystemTray
import java.awt.TrayIcon
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.imageio.ImageIO
import kotlin.system.exitProcess

fun main() {
    AppManager.setEvents(
        onAppStart = {
            setClipboardListener()
        },
        onWindowsEmpty = {
            // NOTE: ウィンドウが閉じてもプログラムを終了させない
        }
    )

    Root()
}