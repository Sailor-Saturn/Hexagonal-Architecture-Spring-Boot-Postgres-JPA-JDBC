package com.arqsoft.server.Service.Port;

import com.arqsoft.server.Domain.Model.DayScheduleAggregate.DaySchedule;

import java.util.List;
import java.util.Optional;

public interface DayScheduleService {

    DaySchedule defineDaySchedule(DaySchedule schedule);

    DaySchedule updateDaySchedule(DaySchedule updatedSchedule);

    boolean removeDaySchedule(Long dayScheduleToRemove);

    List<DaySchedule> getDaySchedules();

    DaySchedule getDayScheduleById(Long id);
}
