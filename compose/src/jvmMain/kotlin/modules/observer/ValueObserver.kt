package modules.observer

interface ValueObserver<T> {
    fun addChangedListener(listener: (T) -> Unit)
    fun setChangedListener(listener: (T) -> Unit)
}
