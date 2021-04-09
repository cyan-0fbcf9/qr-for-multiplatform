import androidx.compose.desktop.AppManager
import functions.setClipboardListener
import views.Root

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