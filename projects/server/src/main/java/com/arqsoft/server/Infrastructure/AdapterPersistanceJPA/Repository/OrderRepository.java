package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.OrderEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByUserEntity(UserEntity userEntity);
}
