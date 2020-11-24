package com.arqsoft.server.Infrastructure.Mapper.Order;

import com.arqsoft.server.Application.Controller.Mapper.Order.StatusMapper;
import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Domain.Model.OrderAggregate.OrderId;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.OrderEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.OrderSnapshotEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.ValueObject.Slot;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.SandwichEntity;
import com.arqsoft.server.Infrastructure.Mapper.Sandwich.SandwichMapper;
import com.arqsoft.server.Infrastructure.Mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static OrderEntity DomainEntityToJPAEntity(Order order) {
        return new OrderEntity(
                StatusMapper.statusToString(order.getStatus()),
                UserMapper.DomainEntityToJpaEntity(order.getStudent()),
                new Slot(order.getSlot().getBeginningHour(),order.getSlot().getEndingDate()),
                SandwichOrderMapper.DomainEntitiesToJPAEntities(order.getSandwichOrder())
        );

    }

    public static List<OrderEntity> DomainEntitiesToJPAEntities(List<Order> ordersList){
        List<OrderEntity> orderEntityList = new ArrayList<>();
        ordersList.forEach(order -> {
            orderEntityList.add(DomainEntityToJPAEntity(order));
        });
        return orderEntityList;
    }

    public static Order JPAEntityToDomainEntity(OrderEntity order) {
        return new Order(
                new OrderId(order.getId()),
                StatusMapper.stringToStatus(order.getStatus()),
                UserMapper.JPAEntityToDomainEntity(order.getUserEntity()),
                new com.arqsoft.server.Domain.Model.OrderAggregate.Slot(order.getSlot().getBeginningHour(),order.getSlot().getEndingHour()),
                SandwichOrderMapper.JpaEntityToDomainEntity(order.getSandwichOrder())
        );
    }

    public static List<Order> JPAEntitiesToDomainEntities(List<OrderEntity> orderEntities) {
        List<Order> orderList = new ArrayList<>();

        orderEntities.forEach(orderEntity -> {
            orderList.add(JPAEntityToDomainEntity(orderEntity));
        });

        return orderList;
    }

//    public static OrderSnapshotEntity JpaEntityToOrderSnapshotEntity(OrderEntity createdOrder) {
//        return new OrderSnapshotEntity(
//                createdOrder.getId(),
//                createdOrder.getStatus(),
//                UserMapper.DomainEntityToUserSnapshotEntity(createdOrder.getUserEntity()),
//                createdOrder.getSlot(),
//                SandwichMapper.DomainEntityToSnapshotEntity(createdOrder.getSandwichOrder())
//        );
//    }
}
