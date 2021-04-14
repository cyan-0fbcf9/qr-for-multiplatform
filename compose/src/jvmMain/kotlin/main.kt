import androidx.compose.desktop.AppManager
import functions.scanAndOpenQR
import modules.singleton.AppService
import views.Root
import javax.swing.SwingUtilities

fun main() {
    AppManager.setEvents(
        onAppStart = {
            AppService.clipImgObserver.setChangedListener(::scanAndOpenQR)
            AppService.clipImgObserver.start()
        },
        onWindowsEmpty = {
            // NOTE: ウィンドウが閉じてもプログラムを終了させない
        }
    )

    SwingUtilities.invokeLater {
        Root()
    }
}