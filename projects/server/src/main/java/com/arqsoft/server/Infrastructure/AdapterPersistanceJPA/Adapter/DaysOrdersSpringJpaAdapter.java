package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Adapter;

import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DaysOrders;
import com.arqsoft.server.Domain.Port.DaysOrdersPersistencePort;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate.DaysOrdersEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate.ValueObject.OrderDate;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository.DaysOrdersRepository;
import com.arqsoft.server.Infrastructure.Mapper.DayScheduleMapper;
import com.arqsoft.server.Infrastructure.Mapper.DaysOrdersMapper;
import com.arqsoft.server.Infrastructure.Mapper.Order.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class DaysOrdersSpringJpaAdapter implements DaysOrdersPersistencePort {

    @Autowired
    private DaysOrdersRepository daysOrdersRepository;

    //@Autowired
    //private DaysOrdersSnapshotRepository ordersSnapshotRepository;

    @Override
    @Transactional
    public DaysOrders createDayOrder(DaysOrders daysOrders) {

        DaysOrdersEntity ordersEntity = DaysOrdersMapper.DomainEntityToJpaEntity(daysOrders);
        daysOrdersRepository.save(ordersEntity);
        //TODO - change to use SnapshotEntity
        //DaysOrdersSnapshotEntity ordersSnapshot = DaysOrdersMapper.JpaEntityToSnapshotEntity(ordersEntity);
        //ordersSnapshotRepository.save(ordersSnapshot);

        return DaysOrdersMapper.JpaEntityToDomainEntity(ordersEntity);
    }

    //TODO change to use SnapshotEntity
    @Override
    @Transactional
    public DaysOrders updateDaysOrders(DaysOrders updatedOrders) {
        Optional<DaysOrdersEntity> optionalDaysOrders = daysOrdersRepository.findById(updatedOrders.getId().getId());

        DaysOrdersEntity daysOrdersEntity = optionalDaysOrders.get();
        //update JPAEntity
        daysOrdersEntity.setDaySchedule(DayScheduleMapper.DomainEntityToJpaEntity(updatedOrders.getDaySchedule()));
        daysOrdersEntity.setOrderDate(new OrderDate(updatedOrders.getDate().getDate()));
        daysOrdersEntity.setOrdersList(OrderMapper.DomainEntitiesToJPAEntities(updatedOrders.getOrderList()));

        daysOrdersRepository.save(daysOrdersEntity);
        return DaysOrdersMapper.JpaEntityToDomainEntity(daysOrdersEntity);
    }

    @Override
    @Transactional
    public boolean removeDaysOrders(Long id) {
        //TODO - change to use SnapshotEntity
        //DaysOrdersSnapshotEntity ordersSnapshot = ordersSnapshotRepository.findByDaysOrdersId(id);
        //ordersSnapshotRepository.deleteById(ordersSnapshot.getId());
        daysOrdersRepository.deleteById(id);
        //return daysOrdersRepository.existsById(id) && ordersSnapshotRepository.existsById(ordersSnapshot.getId());
        return daysOrdersRepository.existsById(id);
    }

    @Override
    public List<DaysOrders> getAllDaysOrders() {
        //TODO - change to return SnapshotEntity
        //List<DaysOrdersSnapshotEntity> snapshotEntities = ordersSnapshotRepository.findAll();
       // return DaysOrdersMapper.SnapshotEntitiesToDomainEntities(snapshotEntities);
        return DaysOrdersMapper.JpaEntitiesToDomainEntities(daysOrdersRepository.findAll());
    }

    @Override
    public DaysOrders getDaysOrdersById(Long id) {
        //TODO - change to return SnapshotEntity
        //return DaysOrdersMapper.SnapshotEntityToDomainEntity(ordersSnapshotRepository.findByDaysOrdersId(id));
        return DaysOrdersMapper.JpaEntityToDomainEntity(daysOrdersRepository.findById(id).get());
    }
}
