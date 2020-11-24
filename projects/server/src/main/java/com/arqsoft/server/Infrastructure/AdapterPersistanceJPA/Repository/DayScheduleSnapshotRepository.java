package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.DayScheduleSnapshotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DayScheduleSnapshotRepository extends JpaRepository<DayScheduleSnapshotEntity, Long> {

    DayScheduleSnapshotEntity findByDayScheduleId(Long id);
}
