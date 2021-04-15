package modules.observer

interface ClipboardObserver<T>: ValueObserver<T> {
    fun onChangedFlavor() {}
}