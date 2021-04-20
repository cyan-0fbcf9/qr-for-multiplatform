package app

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import services.clipboard.ClipboardService
import services.clipboardobserver.ClipboardImageObserverService
import services.clipboardobserver.ClipboardTextObserverService
import services.http.HttpService
import java.awt.Toolkit

object AppService {
    private val clipboardService: ClipboardService = ClipboardService(Toolkit.getDefaultToolkit().systemClipboard)
    val clipImgObserver = ClipboardImageObserverService(clipboardService)
    val clipTxObserver = ClipboardTextObserverService(clipboardService)
    val jacksonMapper = jacksonObjectMapper()
    val httpService = HttpService()
}