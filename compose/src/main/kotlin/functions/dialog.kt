package functions

import extenstion.filePath
import extenstion.isSelected
import java.awt.FileDialog
import java.awt.Frame

fun showSelectFileDialog(parent: Frame = Frame()): String? {
    val fileDialog = FileDialog(parent, "Select File", FileDialog.LOAD).apply {
        isVisible = true
    }
    return if (fileDialog.isSelected) fileDialog.filePath else null
}

fun showSaveFileDialog(parent: Frame? = null): String? {
    val fileDialog = FileDialog(parent, "Save", FileDialog.SAVE).apply {
        file = "Untitled.png"
        isVisible = true
    }
    return if (fileDialog.isSelected) fileDialog.filePath else null
}