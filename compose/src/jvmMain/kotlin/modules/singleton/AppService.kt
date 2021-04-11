package modules.singleton

import services.clipboardobserver.ClipboardImageObserverService
import services.clipboardobserver.ClipboardTextObserverService

object AppService {
    val clipImgObserver = ClipboardImageObserverService()
    val clipTxObserver = ClipboardTextObserverService()
}