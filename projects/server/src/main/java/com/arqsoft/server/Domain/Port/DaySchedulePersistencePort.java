package com.arqsoft.server.Domain.Port;

import com.arqsoft.server.Domain.Model.DayScheduleAggregate.DaySchedule;

import java.util.List;
import java.util.Optional;

public interface DaySchedulePersistencePort {

    DaySchedule defineDaySchedule(DaySchedule schedule);

    DaySchedule updateDaySchedule(DaySchedule updatedSchedule);

    boolean removeDaySchedule(Long id);

    List<DaySchedule> getDaySchedules();

    DaySchedule getDayScheduleById(Long id);
}
