package com.arqsoft.server.Infrastructure.Mapper;

import com.arqsoft.server.Domain.Model.DayScheduleAggregate.*;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.DayScheduleEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.DayScheduleSnapshotEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.BeginningHourJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.EndingHourJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.LastSlotTimeJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.SlotTimeJpa;

import java.util.ArrayList;
import java.util.List;

public class DayScheduleMapper {

    public static DayScheduleEntity DomainEntityToJpaEntity (DaySchedule schedule){
        return new DayScheduleEntity(
                new BeginningHourJpa(schedule.getBeginningHour().getBeginningHour()),
                new EndingHourJpa(schedule.getEndingHour().getEndingHour()),
                new LastSlotTimeJpa(schedule.getLastSlotTime().getLastSlotTime()),
                new SlotTimeJpa(schedule.getSlotTime().getSlotTime())
        );
    }

    public static DayScheduleSnapshotEntity JpaEntityToSnapshotEntity(DayScheduleEntity scheduleEntity){
        return new DayScheduleSnapshotEntity(
                scheduleEntity.getId(),
                scheduleEntity.getBeginningHour(),
                scheduleEntity.getEndingHour(),
                scheduleEntity.getLastSlotTime(),
                scheduleEntity.getSlotTime()
        );
    }

    public static DaySchedule JpaEntityToDomainEntity (DayScheduleEntity scheduleEntity){
        return new DaySchedule(
                new DayScheduleId(scheduleEntity.getId()),
                new BeginningHour(scheduleEntity.getBeginningHour().getBeginningHour()),
                new LastSlotTime(scheduleEntity.getLastSlotTime().getLastSlotTime()),
                new EndingHour(scheduleEntity.getEndingHour().getEndingHour()),
                new SlotTime(scheduleEntity.getSlotTime().getSlotTime())
        );
    }

    public static DaySchedule SnapshotEntityToDomainEntity(DayScheduleSnapshotEntity snapshotSchedule){
        return new DaySchedule (
                new DayScheduleId(snapshotSchedule.getDayScheduleId()),
                new BeginningHour(snapshotSchedule.getBeginningHour().getBeginningHour()),
                new LastSlotTime(snapshotSchedule.getLastSlotTime().getLastSlotTime()),
                new EndingHour(snapshotSchedule.getEndingHour().getEndingHour()),
                new SlotTime(snapshotSchedule.getSlotTime().getSlotTime())
        );
    }

    public static List<DaySchedule> JpaEntitiesToDomainEntities(List<DayScheduleEntity> dayScheduleEntities){
        List<DaySchedule> dayScheduleList = new ArrayList<>();
        dayScheduleEntities.forEach( scheduleEntity -> {
            dayScheduleList.add(JpaEntityToDomainEntity(scheduleEntity));
        });
        return dayScheduleList;
    }

    public static List<DaySchedule> SnapshotEntitiesToDomainEntities(List<DayScheduleSnapshotEntity> snapshotEntities){
        List<DaySchedule> dayScheduleSnapshotList = new ArrayList<>();
        snapshotEntities.forEach( snapshotEntity -> {
            dayScheduleSnapshotList.add(SnapshotEntityToDomainEntity(snapshotEntity));
        });
        return dayScheduleSnapshotList;
    }
}
