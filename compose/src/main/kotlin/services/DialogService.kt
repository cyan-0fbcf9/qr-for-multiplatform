package services

import extenstion.filePath
import extenstion.isSelected
import java.awt.FileDialog
import java.awt.Frame

class DialogService(
    private val parent: Frame? = null
) {
    fun showSelectFileDialog(): String? {
        val fileDialog = FileDialog(parent, "Select File", FileDialog.LOAD).apply {
            isVisible = true
        }
        return if (fileDialog.isSelected) fileDialog.filePath else null
    }

    fun showSaveFileDialog(): String? {
        val fileDialog = FileDialog(parent, "Save", FileDialog.SAVE).apply {
            file = "Untitled.png"
            isVisible = true
        }
        return if (fileDialog.isSelected) fileDialog.filePath else null
    }
}