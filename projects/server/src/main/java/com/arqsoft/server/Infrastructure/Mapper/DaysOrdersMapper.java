package com.arqsoft.server.Infrastructure.Mapper;

import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DatePrimitive;
import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DaysOrders;
import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DaysOrdersId;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate.DaysOrdersEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate.DaysOrdersSnapshotEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate.ValueObject.OrderDate;
import com.arqsoft.server.Infrastructure.Mapper.Order.OrderMapper;

import java.util.ArrayList;
import java.util.List;

public class DaysOrdersMapper {

    public static DaysOrdersEntity DomainEntityToJpaEntity (DaysOrders orders){
        return new DaysOrdersEntity(
                new OrderDate(orders.getDate().getDate()),
                DayScheduleMapper.DomainEntityToJpaEntity(orders.getDaySchedule()),
                OrderMapper.DomainEntitiesToJPAEntities(orders.getOrderList())
        );
    }

    //TODO implement - missing OrderSnapshotEntity
    public static DaysOrdersSnapshotEntity JpaEntityToSnapshotEntity(DaysOrdersEntity ordersEntity){
        return null;
    }

    //TODO implement - missing Order
    public static DaysOrders JpaEntityToDomainEntity (DaysOrdersEntity ordersEntity){

        return new DaysOrders(
                new DaysOrdersId(ordersEntity.getId().longValue()),
                new DatePrimitive(ordersEntity.getOrderDate().getOrderDate()),
                OrderMapper.JPAEntitiesToDomainEntities(ordersEntity.getOrdersList()),
                DayScheduleMapper.JpaEntityToDomainEntity(ordersEntity.getDaySchedule())
        );
    }

    //TODO implement - missing OrderSnapshotEntity
    public static DaysOrders SnapshotEntityToDomainEntity(DaysOrdersSnapshotEntity snapshotOrders){
        return null;
    }

    public static List<DaysOrders> JpaEntitiesToDomainEntities(List<DaysOrdersEntity> ordersEntities){
        List<DaysOrders> ordersList = new ArrayList<>();
        ordersEntities.forEach( orderEntity -> {
            ordersList.add(JpaEntityToDomainEntity(orderEntity));
        });
        return ordersList;
    }

    public static List<DaysOrders> SnapshotEntitiesToDomainEntities(List<DaysOrdersSnapshotEntity> snapshotEntities){
        List<DaysOrders> ordersSnapshotList = new ArrayList<>();
        snapshotEntities.forEach( snapshotEntity -> {
            ordersSnapshotList.add(SnapshotEntityToDomainEntity(snapshotEntity));
        });
        return ordersSnapshotList;
    }
}
