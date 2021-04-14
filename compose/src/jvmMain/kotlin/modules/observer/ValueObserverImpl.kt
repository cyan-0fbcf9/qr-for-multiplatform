package modules.observer

abstract class ValueObserverImpl<T>(protected val initValue: T?) : ValueObserver<T> {
    private var _value: T? = initValue
    private val listeners: MutableList<(T) -> Unit> = mutableListOf()

    private val value: T?
        get() = this._value
    protected val latestValue: T?
        get() = this._value

    /**
     * 初期値をインスタンス生成後に行う場合のみ有効
     */
    protected open fun lazyInitValue(initValue: T) {
        _value = initValue
    }

    protected open fun update(newValue: T) {
        _value = newValue
        listeners.forEach { listener ->
            listener(newValue)
        }
    }

    /**
     * @return 値を更新したらtrue, それ以外はfalse
     */
    protected open fun tryUpdating(newValue: T): Boolean = when {
        latestValue != newValue -> {
            update(newValue)
            true
        }
        else -> {
            false
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
