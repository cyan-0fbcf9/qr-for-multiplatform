package modules.observer

import java.util.*
import kotlin.concurrent.fixedRateTimer

abstract class ScheduleValueObserverImpl<T>(initValue: T?, interval: Long = 100) :
    ValueObserverImpl<T>(initValue = initValue), ScheduleValueObserver<T> {
    private var timer: Timer =
        fixedRateTimer(initialDelay = 500, period = interval, action = ::scheduleObserveTask)

    /**
     * @return 値を更新したらtrue, それ以外はfalse
     */
    override fun tryUpdating(newValue: T): Boolean = when {
        latestValue == null -> {
            lazyInitValue(newValue)
            false
        }
        latestValue != newValue -> {
            update(newValue)
            true
        }
        else -> {
            false
        }
    }

    override fun stop() {
        timer.cancel()
    }
}