package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Adapter;

import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Domain.Port.OrderPersistencePort;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.OrderEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.OrderSnapshotEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository.OrderRepository;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository.OrderSnapshotRepository;
import com.arqsoft.server.Infrastructure.Mapper.Order.OrderMapper;
import com.arqsoft.server.Infrastructure.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderSpringJpaAdapter implements OrderPersistencePort {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderSnapshotRepository orderSnapshotRepository;

    @Override
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = OrderMapper.DomainEntityToJPAEntity(order);
        OrderEntity createdOrder = orderRepository.save(orderEntity);

/*        OrderSnapshotEntity orderSnapshotEntity = OrderMapper.JpaEntityToOrderSnapshotEntity(createdOrder);
        orderSnapshotRepository.save(orderSnapshotEntity);*/

        return OrderMapper.JPAEntityToDomainEntity(createdOrder);
    }

    @Override
    public List<Order> findByUser(User user) {
        UserEntity userEntity = UserMapper.DomainEntityToJpaEntity(user);

        List<OrderEntity> orderEntities = orderRepository.findByUserEntity(userEntity);

        return OrderMapper.JPAEntitiesToDomainEntities(orderEntities);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {

        Optional<OrderEntity> order = orderRepository.findById(id);

        return order.map(OrderMapper::JPAEntityToDomainEntity);
    }

    @Override
    public List<Order> getOrdersList() {
        List<OrderEntity> orderEntities = orderRepository.findAll();

        return OrderMapper.JPAEntitiesToDomainEntities(orderEntities);
    }
}
