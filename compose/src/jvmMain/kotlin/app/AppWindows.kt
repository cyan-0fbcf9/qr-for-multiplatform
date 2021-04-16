package app

import androidx.compose.desktop.AppFrame
import androidx.compose.desktop.AppManager
import extentions.toTop
import views.QRScreenshot
import views.Usage

object AppWindows {
    val stackedWindows = mutableListOf<AppFrame>()

    object DefinedWindow {
        const val USAGE: String = "Usage"
        const val QR_SCREENSHOT: String = "QR Screenshot"
    }

    fun viewUsage() {
        AppManager.windows.find { searchedWindow ->
            searchedWindow.title == DefinedWindow.USAGE
        }.let { foundWindow ->
            if (foundWindow != null) {
                foundWindow.window.toTop()
            } else {
                Usage()
            }
        }
    }

    fun viewQRScreenshot() {
        AppManager.windows.find { searchedWindow ->
            searchedWindow.title == DefinedWindow.QR_SCREENSHOT
        }.let { foundWindow ->
            if (foundWindow != null) {
                foundWindow.window.toTop()
            } else {
                QRScreenshot()
            }
        }
    }
}