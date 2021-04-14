package services.clipboardobserver

import extenstion.toByteArray
import java.awt.image.BufferedImage
import java.util.*

class ClipboardImageObserverService : ClipboardObserverServiceImpl<BufferedImage>() {
    override fun scheduleObserveTask(task: TimerTask) {
        val image = clipService.getImage() ?: return
        tryUpdating(newValue = image)
    }

    override fun tryUpdating(newValue: BufferedImage): Boolean = when {
        latestValue == null -> {
            lazyInitValue(newValue)
            false
        }
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