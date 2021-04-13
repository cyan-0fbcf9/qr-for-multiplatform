package modules.observer

import modules.schedule.ScheduleController
import java.util.*

interface ScheduleValueObserver<T> : ValueObserver<T>, ScheduleController {
    fun scheduleObserveTask(task: TimerTask): Unit
    fun beforeStartingSchedule()
}