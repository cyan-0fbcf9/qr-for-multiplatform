import extentions.filePath
import extentions.isSelected
import java.awt.FileDialog
import java.awt.Frame
import java.io.FilenameFilter

actual fun openSelectDialog(parent: Any?): String? {
    val parentFrame = parent as? Frame ?: throw NullPointerException("")
    val fileDialog = try {
        FileDialog(parentFrame, "ファイル選択", FileDialog.LOAD).apply {
            filenameFilter = FilenameFilter { _, name ->
                name.matches(Regex("""^.*\.(png|jpeg|jpg|gif)$"""))
            }
            isVisible = true
        }
    } catch (e: IllegalArgumentException) {
        return null
    }

    return if (fileDialog.isSelected) fileDialog.filePath else null
}

actual fun openSaveDialog(parent: Any?): String? {
    val parentFrame = parent as? Frame ?: throw NullPointerException("")
    val fileDialog = FileDialog(parentFrame, "ファイル保存", FileDialog.SAVE).apply {
        file = "Untitled.png"
        isVisible = true
    }
    return if (fileDialog.isSelected) fileDialog.filePath else null
}
