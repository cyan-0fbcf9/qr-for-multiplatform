package modules.observer

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard

abstract class ClipboardObserverImpl<T>(private val clipboard: Clipboard = Toolkit.getDefaultToolkit().systemClipboard) :
    ScheduleValueObserverImpl<T>(null) {
}