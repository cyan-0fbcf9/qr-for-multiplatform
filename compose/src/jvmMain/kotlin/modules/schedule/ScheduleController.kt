package modules.schedule

import java.util.*

interface ScheduleController {
    fun start()
    fun stop()
    fun beforeStartingSchedule()
    fun scheduleObserveTask(task: TimerTask): Unit
}