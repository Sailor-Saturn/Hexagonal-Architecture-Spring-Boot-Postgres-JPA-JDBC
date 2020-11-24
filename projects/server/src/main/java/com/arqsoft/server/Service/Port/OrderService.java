package com.arqsoft.server.Service.Port;

import com.arqsoft.server.Domain.Model.Enum.Status;
import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Domain.Model.OrderAggregate.Quantity;
import com.arqsoft.server.Domain.Model.OrderAggregate.SandwichOrder;

import java.util.List;
import java.util.Map;

public interface OrderService {

    SandwichOrder createSandwichOrder(Map<Long, Quantity> sandwichOrder);

    Order createOrder(Order order);

    List<Order> getOrdersListById(List<Long> ordersList);

    Order getOrderById(Long id);

    Order changeOrder(Order order, Status status);

    List<Order> getOrdersList();
}
