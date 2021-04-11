package services.clipboardobserver

import modules.observer.ClipboardObserverImpl
import services.clipboard.ClipboardService

abstract class ClipboardObserverServiceImpl<T>(protected val clipService: ClipboardService = ClipboardService()) :
    ClipboardObserverImpl<T>() {
}