package modules.observer

abstract class ValueObserverImpl<T>(initValue: T?) : ValueObserver<T> {
    private var _value: T? = initValue
    private val listeners: MutableList<(T) -> Unit> = mutableListOf()

    private val value: T?
        get() = this._value
    protected val latestValue: T?
        get() = this._value

    /**
     * 初期値をインスタンス生成後に行う場合のみ有効
     */
    protected fun lazyInitValue(initValue: T) {
        if (value == null) {
            _value = initValue
        }
    }

    protected fun update(newValue: T) {
        _value = newValue
        listeners.forEach { listener ->
            listener(newValue)
        }
    }

    override fun addChangedListener(listener: (T) -> Unit) {
        listeners.add(listener)
    }

    override fun setChangedListener(listener: (T) -> Unit) {
        listeners.clear()
        listeners.add(listener)
    }
}
