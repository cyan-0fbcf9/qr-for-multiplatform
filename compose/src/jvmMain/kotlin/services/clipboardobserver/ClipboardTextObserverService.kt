package services.clipboardobserver

import services.clipboard.ClipboardService
import java.util.*

class ClipboardTextObserverService(clipboardService: ClipboardService) :
    ClipboardObserverServiceImpl<String>(clipboardService, clipboardService.getString()) {
    override fun scheduleObserveTask(task: TimerTask) {
        val text = clipboardService.getString() ?: return
        tryUpdating(newValue = text)
    }

    override fun beforeStartingSchedule() {
        super.beforeStartingSchedule()
    }
}