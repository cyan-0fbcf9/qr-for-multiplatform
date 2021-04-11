package services.clipboardobserver

import java.awt.image.BufferedImage
import java.util.*

class ClipboardImageObserverService : ClipboardObserverServiceImpl<BufferedImage>() {
    override fun scheduleObserveTask(task: TimerTask) {
        val image = clipService.getImage() ?: return
        tryUpdating(newValue = image)
    }
}