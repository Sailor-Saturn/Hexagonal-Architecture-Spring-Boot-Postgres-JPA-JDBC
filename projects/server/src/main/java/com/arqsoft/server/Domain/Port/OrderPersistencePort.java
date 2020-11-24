package com.arqsoft.server.Domain.Port;

import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Domain.Model.UserAggregate.User;

import java.util.List;
import java.util.Optional;

public interface OrderPersistencePort {
    Order saveOrder(Order order);

    List<Order> findByUser(User user);

    Optional<Order> getOrderById(Long id);

    List<Order> getOrdersList();
}
