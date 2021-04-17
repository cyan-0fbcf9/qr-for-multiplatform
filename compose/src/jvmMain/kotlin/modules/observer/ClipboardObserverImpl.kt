package modules.observer

abstract class ClipboardObserverImpl<T>(initValue: T?) :
    ScheduleValueObserverImpl<T>(initValue, interval = 200), ClipboardObserver<T> {

    override fun onChangedFlavor() {}
}