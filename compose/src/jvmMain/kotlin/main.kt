import androidx.compose.desktop.AppManager
import functions.setClipboardListener
import views.Root
import javax.swing.SwingUtilities

fun main() {
    AppManager.setEvents(
        onAppStart = {
            setClipboardListener()
        },
        onWindowsEmpty = {
            // NOTE: ウィンドウが閉じてもプログラムを終了させない
        }
    )

    SwingUtilities.invokeLater {
        Root()
    }
}