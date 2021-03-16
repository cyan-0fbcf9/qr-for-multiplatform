import java.awt.FileDialog
import java.awt.Frame
import java.io.File
import java.io.FilenameFilter

actual fun openFileSelect(parent: Any?): String? {
    val parentFrame = parent as? Frame
    val fileDialog = FileDialog(parentFrame, "Select Image", FileDialog.LOAD).apply {
        filenameFilter = FilenameFilter { _, name ->
            name.matches(Regex("""^.*\.(png|jpeg|jpg|gif)$"""))
        }
        isVisible = true
    }
    return if (fileDialog.isSelected) fileDialog.filePath else null
}

val FileDialog.isSelected: Boolean
    get() = this.file != null

val FileDialog.filePath: String
    get() = this.directory + this.file

val FileDialog.fileInstance: File
    get() = File(this.filePath)