import platform.AppKit.*

actual fun openSelectDialog(parent: Any?): String? {
    val dialog = NSOpenPanel().apply {
        title = "ファイル選択"
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

actual fun openSaveDialog(parent: Any?): String? {
    val dialog = NSSavePanel().apply {
        title = "ファイル保存"
        canCreateDirectories = true
        showsTagField = false
    }
    return if (dialog.runModal() == NSModalResponseOK) {
        dialog.URL?.path
    } else {
        null
    }
}
