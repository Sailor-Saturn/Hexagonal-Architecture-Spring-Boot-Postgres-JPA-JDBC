package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
