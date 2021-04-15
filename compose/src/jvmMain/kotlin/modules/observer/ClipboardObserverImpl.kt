package modules.observer

abstract class ClipboardObserverImpl<T>(initValue: T?) :
    ScheduleValueObserverImpl<T>(initValue), ClipboardObserver<T> {

    override fun onChangedFlavor() {}
}