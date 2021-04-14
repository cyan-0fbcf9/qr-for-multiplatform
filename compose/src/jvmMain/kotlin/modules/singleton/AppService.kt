package modules.singleton

import services.clipboard.ClipboardService
import services.clipboardobserver.ClipboardImageObserverService
import services.clipboardobserver.ClipboardTextObserverService
import java.awt.Toolkit

object AppService {
    private val clipboardService: ClipboardService = ClipboardService(Toolkit.getDefaultToolkit().systemClipboard)
    val clipImgObserver = ClipboardImageObserverService(clipboardService)
    val clipTxObserver = ClipboardTextObserverService(clipboardService)
}