package modules.observer

abstract class ClipboardObserverImpl<T> :
    ScheduleValueObserverImpl<T>(null), ClipboardObserver<T> {

    override fun onChangedFlavor() {}
}