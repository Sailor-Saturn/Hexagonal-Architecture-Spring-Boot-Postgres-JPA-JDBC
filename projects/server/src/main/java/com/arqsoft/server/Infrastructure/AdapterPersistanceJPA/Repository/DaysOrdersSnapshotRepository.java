package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate.DaysOrdersSnapshotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysOrdersSnapshotRepository extends JpaRepository<DaysOrdersSnapshotEntity,Long> {

    DaysOrdersSnapshotEntity findByDaysOrdersId(Long id);
}
