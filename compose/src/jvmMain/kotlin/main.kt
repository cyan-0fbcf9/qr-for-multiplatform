import androidx.compose.desktop.AppManager
import functions.setClipboardListener
import views.Main
import java.awt.PopupMenu
import java.awt.SystemTray
import java.awt.TrayIcon
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.imageio.ImageIO

fun main() {
    AppManager.setEvents(
        onAppStart = {
            setClipboardListener()
        },
        onWindowsEmpty = {
            // NOTE: ウィンドウが閉じてもプログラムを終了させない
        }
    )
    Main()
}