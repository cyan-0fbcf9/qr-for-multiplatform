package modules.observer

import java.util.*
import kotlin.concurrent.fixedRateTimer

abstract class ScheduleValueObserverImpl<T>(initValue: T?, interval: Long = 100) :
    ValueObserverImpl<T>(initValue = initValue), ScheduleValueObserver<T> {
    private var timer: Timer =
        fixedRateTimer(initialDelay = 1000, period = interval, action = ::scheduleObserveTask)

    override fun stop() {
        timer.cancel()
    }
}