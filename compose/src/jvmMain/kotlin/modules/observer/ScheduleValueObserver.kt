package modules.observer

import modules.schedule.ScheduleController
import java.util.*

interface ScheduleValueObserver<T> : ValueObserver<T>, ScheduleController {
}