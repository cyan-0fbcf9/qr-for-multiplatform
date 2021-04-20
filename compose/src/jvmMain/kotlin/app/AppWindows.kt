package app

import androidx.compose.desktop.AppFrame
import androidx.compose.desktop.AppManager
import extentions.toTop
import views.QRScreenshot
import views.Updating
import views.Usage

object AppWindows {
    val stackedWindows = mutableListOf<AppFrame>()

    object DefinedWindow {
        const val USAGE: String = "Usage"
        const val QR_SCREENSHOT: String = "QR Screenshot"
        const val UPDATING: String = "Update"
    }

    private fun viewFocusWindow(targetTitle: String, targetBuilder: () -> Unit) {
        AppManager.windows.find { searchedWindow ->
            searchedWindow.title == targetTitle
        }.let { foundWindow ->
            if (foundWindow != null) {
                foundWindow.window.toTop()
            } else {
                targetBuilder()
            }
        }
    }

    fun viewUsage() {
        viewFocusWindow(DefinedWindow.USAGE, ::Usage)
    }

    fun viewQRScreenshot() {
        viewFocusWindow(DefinedWindow.QR_SCREENSHOT, ::QRScreenshot)
    }

    fun viewUpdating() {
        viewFocusWindow(DefinedWindow.UPDATING, ::Updating)
    }
}