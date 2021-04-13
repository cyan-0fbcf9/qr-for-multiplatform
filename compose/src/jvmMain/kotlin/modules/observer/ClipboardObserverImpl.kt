package modules.observer

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard

abstract class ClipboardObserverImpl<T> :
    ScheduleValueObserverImpl<T>(null), ClipboardObserver {

    override fun onChangedFlavor() {}
}