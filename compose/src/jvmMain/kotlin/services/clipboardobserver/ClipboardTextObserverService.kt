package services.clipboardobserver

import java.util.*

class ClipboardTextObserverService : ClipboardObserverServiceImpl<String>() {
    override fun scheduleObserveTask(task: TimerTask) {
        val text = clipService.getString() ?: return
        tryUpdating(newValue = text)
    }
}