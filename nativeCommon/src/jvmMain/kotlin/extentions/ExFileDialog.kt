package extentions

import java.awt.FileDialog
import java.io.File

val FileDialog.isSelected: Boolean
    get() = this.file != null

val FileDialog.filePath: String
    get() = this.directory + this.file

val FileDialog.fileInstance: File
    get() = File(this.filePath)
