package services.clipboardobserver

import modules.observer.ClipboardObserverImpl
import services.clipboard.ClipboardService

abstract class ClipboardObserverServiceImpl<T>(val clipboardService: ClipboardService, initValue: T? = null) : ClipboardObserverImpl<T>(initValue) {
    init {
        clipboardService.addFlavorListener {
            this::onChangedFlavor.invoke()
        }
    }
}