package modules.observer

import java.util.*
import kotlin.concurrent.fixedRateTimer

abstract class ScheduleValueObserverImpl<T>(initValue: T?, private val interval: Long = 100) :
    ValueObserverImpl<T>(initValue = initValue), ScheduleValueObserver<T> {

    private var timer: Timer? = null

    override fun beforeStartingSchedule() {}

    override fun start() {
        ::beforeStartingSchedule.invoke()
        this.timer = fixedRateTimer(initialDelay = 1000, period = interval, action = ::scheduleObserveTask)
    }

    override fun stop() {
        timer?.cancel()
    }
}