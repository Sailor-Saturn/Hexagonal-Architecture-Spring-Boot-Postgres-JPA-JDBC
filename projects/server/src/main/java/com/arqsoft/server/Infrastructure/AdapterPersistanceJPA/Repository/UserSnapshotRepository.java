package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository;


import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserSnapshotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSnapshotRepository extends JpaRepository<UserSnapshotEntity, Long> {
}
