package services.clipboard

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.FlavorListener

class ClipboardService(clipboard: Clipboard = Toolkit.getDefaultToolkit().systemClipboard) :
    ClipboardServiceableImpl(clipboard) {
    constructor(
        clipboard: Clipboard = Toolkit.getDefaultToolkit().systemClipboard,
        onFlavorListener: FlavorListener
    ) : this(clipboard) {
        clipboard.addFlavorListener(onFlavorListener)
    }
}
