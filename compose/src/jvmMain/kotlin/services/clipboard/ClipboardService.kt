package services.clipboard

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard

class ClipboardService(clipboard: Clipboard = Toolkit.getDefaultToolkit().systemClipboard) :
    ClipboardServiceableImpl(clipboard) {
}
