import platform.AppKit.NSModalResponseOK
import platform.AppKit.NSOpenPanel
import platform.AppKit.showsResizeIndicator

actual fun openFileSelect(parent: Any?): String? {
    val dialog = NSOpenPanel().apply {
        title = "Select File"
        showsResizeIndicator = true
        showsHiddenFiles = false
        allowsMultipleSelection = false
        canChooseDirectories = false
        allowedFileTypes = listOf("png", "jpg", "jpeg", "gif")
    }
    return if (dialog.runModal() == NSModalResponseOK) {
        dialog.URL?.path
    } else {
        null
    }
}
