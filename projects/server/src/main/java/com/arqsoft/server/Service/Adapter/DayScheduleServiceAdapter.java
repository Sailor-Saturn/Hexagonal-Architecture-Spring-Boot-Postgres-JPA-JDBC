package com.arqsoft.server.Service.Adapter;

import com.arqsoft.server.Domain.Model.DayScheduleAggregate.DaySchedule;
import com.arqsoft.server.Domain.Port.DaySchedulePersistencePort;
import com.arqsoft.server.Service.Port.DayScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayScheduleServiceAdapter implements DayScheduleService {

    @Autowired
    DaySchedulePersistencePort schedulePersistence;

    @Override
    public DaySchedule defineDaySchedule(DaySchedule schedule) {
        return schedulePersistence.defineDaySchedule(schedule);
    }

    @Override
    public DaySchedule updateDaySchedule(DaySchedule updatedSchedule) {
        return schedulePersistence.updateDaySchedule(updatedSchedule);
    }

    @Override
    public boolean removeDaySchedule(Long id) {
        return schedulePersistence.removeDaySchedule(id);
    }

    @Override
    public List<DaySchedule> getDaySchedules() {
        return schedulePersistence.getDaySchedules();
    }

    @Override
    public DaySchedule getDayScheduleById(Long id) {
        return schedulePersistence.getDayScheduleById(id);
    }
}
