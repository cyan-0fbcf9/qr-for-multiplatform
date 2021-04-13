package services.clipboardobserver

import modules.observer.ClipboardObserverImpl
import services.clipboard.ClipboardService
import java.awt.Toolkit

abstract class ClipboardObserverServiceImpl<T>() : ClipboardObserverImpl<T>() {
    protected val clipService: ClipboardService = ClipboardService(
        clipboard = Toolkit.getDefaultToolkit().systemClipboard,
        onFlavorListener = {
            this::onChangedFlavor.invoke()
        }
    )
}