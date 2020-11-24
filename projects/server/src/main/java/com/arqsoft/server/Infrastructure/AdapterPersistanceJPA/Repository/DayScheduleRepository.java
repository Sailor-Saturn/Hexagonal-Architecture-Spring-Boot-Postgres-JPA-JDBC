package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.DayScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayScheduleRepository extends JpaRepository<DayScheduleEntity, Long> {
}
