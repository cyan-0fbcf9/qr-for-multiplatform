package extentions

import java.awt.Window

fun Window.toTop() {
    if (isAlwaysOnTopSupported) {
        isAlwaysOnTop = true
        isAlwaysOnTop = false
    }
}