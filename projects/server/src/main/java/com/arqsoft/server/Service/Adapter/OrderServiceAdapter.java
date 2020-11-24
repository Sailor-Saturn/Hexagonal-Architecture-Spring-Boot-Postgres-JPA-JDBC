package com.arqsoft.server.Service.Adapter;

import com.arqsoft.server.Domain.Model.Enum.Status;
import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Domain.Model.OrderAggregate.Quantity;
import com.arqsoft.server.Domain.Model.OrderAggregate.SandwichOrder;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Domain.Port.OrderPersistencePort;
import com.arqsoft.server.Domain.Port.SandwichPersistencePort;
import com.arqsoft.server.Service.Port.OrderService;
import com.arqsoft.server.Service.Port.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderServiceAdapter implements OrderService {

    @Autowired
    private SandwichService sandwichService;

    @Autowired
    private OrderPersistencePort orderPersistencePort;

    @Override
    public SandwichOrder createSandwichOrder(Map<Long, Quantity> dtoSandwichOrderMap) {

        SandwichOrder sandwichOrder = new SandwichOrder();
        for (Map.Entry<Long, Quantity> entry : dtoSandwichOrderMap.entrySet()) {
            Optional<Sandwich> sandwich = sandwichService.getSandwichById(entry.getKey());

            if (sandwich.isPresent()) {
               sandwichOrder.addSandwichQuantity(sandwich.get(),entry.getValue());
            }
        }

        return sandwichOrder;
    }

    @Override
    public Order createOrder(Order order) {
        return orderPersistencePort.saveOrder(order);
    }

    @Override
    public List<Order> getOrdersListById(List<Long> ordersIdList) {
        List<Order> ordersList = new ArrayList<>();

        ordersIdList.forEach( orderId -> {
            ordersList.add(getOrderById(orderId));
        });
        return ordersList;
    }

    @Override
    public Order getOrderById(Long id) {

        Optional<Order> optionalOrder = orderPersistencePort.getOrderById(id);

        if (!optionalOrder.isPresent()) {
            throw new IllegalArgumentException("There's no order with the associated id");
        }
        return optionalOrder.get();
    }

    @Override
    public Order changeOrder(Order order, Status status) {
        order.setStatus(status);

        return orderPersistencePort.saveOrder(order);
    }

    @Override
    public List<Order> getOrdersList() {
        return orderPersistencePort.getOrdersList();
    }
}
