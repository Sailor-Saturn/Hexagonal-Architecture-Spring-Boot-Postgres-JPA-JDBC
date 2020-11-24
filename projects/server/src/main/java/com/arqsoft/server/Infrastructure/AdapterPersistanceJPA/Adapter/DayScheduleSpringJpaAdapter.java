package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Adapter;

import com.arqsoft.server.Domain.Model.DayScheduleAggregate.DaySchedule;
import com.arqsoft.server.Domain.Port.DaySchedulePersistencePort;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.DayScheduleEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.DayScheduleSnapshotEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.BeginningHourJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.EndingHourJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.LastSlotTimeJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.SlotTimeJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository.DayScheduleRepository;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository.DayScheduleSnapshotRepository;
import com.arqsoft.server.Infrastructure.Mapper.DayScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class DayScheduleSpringJpaAdapter implements DaySchedulePersistencePort {

    @Autowired
    private DayScheduleRepository scheduleRepository;

    @Autowired
    private DayScheduleSnapshotRepository dayScheduleSnapshotRepository;

    @Override
    @Transactional
    public DaySchedule defineDaySchedule(DaySchedule schedule) {

        DayScheduleEntity scheduleEntity = DayScheduleMapper.DomainEntityToJpaEntity(schedule);
        scheduleRepository.save(scheduleEntity);
        DayScheduleSnapshotEntity scheduleSnapshot = DayScheduleMapper.JpaEntityToSnapshotEntity(scheduleEntity);
        dayScheduleSnapshotRepository.save(scheduleSnapshot);

        return DayScheduleMapper.JpaEntityToDomainEntity(scheduleEntity);
    }

    @Override
    @Transactional
    public DaySchedule updateDaySchedule(DaySchedule updatedSchedule) {

        Optional<DayScheduleEntity> oldScheduleEntity = scheduleRepository.findById(updatedSchedule.getDayScheduleId().getId());
        //TODO handle error exception
        DayScheduleEntity newScheduleEntity = oldScheduleEntity.get();
        //update JPAEntity
        newScheduleEntity.setBeginningHour(new BeginningHourJpa(updatedSchedule.getBeginningHour().getBeginningHour()));
        newScheduleEntity.setEndingHour(new EndingHourJpa(updatedSchedule.getEndingHour().getEndingHour()));
        newScheduleEntity.setSlotTime(new SlotTimeJpa(updatedSchedule.getSlotTime().getSlotTime()));
        newScheduleEntity.setLastSlotTime(new LastSlotTimeJpa(updatedSchedule.getLastSlotTime().getLastSlotTime()));

        scheduleRepository.save(newScheduleEntity);
        DayScheduleSnapshotEntity oldSnapshot = dayScheduleSnapshotRepository.findByDayScheduleId(newScheduleEntity.getId().longValue());
        //update SnapshotEntity
        oldSnapshot.setBeginningHour(newScheduleEntity.getBeginningHour());
        oldSnapshot.setEndingHour(newScheduleEntity.getEndingHour());
        oldSnapshot.setLastSlotTime(newScheduleEntity.getLastSlotTime());
        oldSnapshot.setSlotTime(newScheduleEntity.getSlotTime());
        dayScheduleSnapshotRepository.save(oldSnapshot);

        return DayScheduleMapper.JpaEntityToDomainEntity(newScheduleEntity);
    }

    @Override
    @Transactional
    public boolean removeDaySchedule(Long dayScheduleId) {
        DayScheduleSnapshotEntity scheduleSnapshot = dayScheduleSnapshotRepository.findByDayScheduleId(dayScheduleId);
        dayScheduleSnapshotRepository.deleteById(scheduleSnapshot.getId());
        scheduleRepository.deleteById(dayScheduleId);
        return scheduleRepository.existsById(dayScheduleId) && dayScheduleSnapshotRepository.existsById(scheduleSnapshot.getId());
    }

    @Override
    public List<DaySchedule> getDaySchedules() {
        List<DayScheduleSnapshotEntity> snapshotEntities = dayScheduleSnapshotRepository.findAll();
        return DayScheduleMapper.SnapshotEntitiesToDomainEntities(snapshotEntities);
    }

    @Override
    public DaySchedule getDayScheduleById(Long id) {
        return DayScheduleMapper.SnapshotEntityToDomainEntity(dayScheduleSnapshotRepository.findByDayScheduleId(id));
    }
}
