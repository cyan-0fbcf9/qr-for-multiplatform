package services.clipboardobserver

import extenstion.toByteArray
import services.clipboard.ClipboardService
import java.awt.image.BufferedImage
import java.util.*

class ClipboardImageObserverService(clipboardService: ClipboardService) :
    ClipboardObserverServiceImpl<BufferedImage>(clipboardService, clipboardService.getImage()) {
    override fun scheduleObserveTask(task: TimerTask) {
        val image = clipboardService.getImage() ?: return
        tryUpdating(newValue = image)
    }

    override fun tryUpdating(newValue: BufferedImage): Boolean = when {
        !latestValue?.toByteArray().contentEquals(newValue.toByteArray()) -> {
            update(newValue)
            true
        }
        else -> {
            false
        }
    }

    override fun beforeStartingSchedule() {
        super.beforeStartingSchedule()
    }
}