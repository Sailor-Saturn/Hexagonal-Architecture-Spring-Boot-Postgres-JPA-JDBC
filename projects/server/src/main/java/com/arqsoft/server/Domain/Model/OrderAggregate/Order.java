package com.arqsoft.server.Domain.Model.OrderAggregate;

import com.arqsoft.server.Domain.Interface.Entity;
import com.arqsoft.server.Domain.Model.Enum.Status;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import org.apache.commons.lang3.Validate;

public class Order implements Entity {

    private OrderId orderId;
    private Status status;
    private User student;
    private Slot slot;
    private SandwichOrder sandwichOrder;

    public Order(Status status, User student, Slot slot, SandwichOrder sandwichOrder) {
        Validate.notNull(status);
        Validate.notNull(student);
        Validate.notNull(slot);
        Validate.notNull(sandwichOrder);
        this.status = status;
        this.student = student;
        this.slot = slot;
        this.sandwichOrder = sandwichOrder;
    }

    public Order(OrderId orderId, Status status, User student, Slot slot, SandwichOrder sandwichOrder) {
        Validate.notNull(status);
        Validate.notNull(student);
        Validate.notNull(slot);
        Validate.notNull(sandwichOrder);
        this.orderId = orderId;
        this.status = status;
        this.student = student;
        this.slot = slot;
        this.sandwichOrder = sandwichOrder;
    }

    public boolean hasSandwich(Sandwich sandwich) {
        return sandwichOrder.hasSandwich(sandwich);
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Status getStatus() {
        return status;
    }

    public User getStudent() {
        return student;
    }

    public Slot getSlot() {
        return slot;
    }

    public SandwichOrder getSandwichOrder() {
        return sandwichOrder;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void setSandwichOrder(SandwichOrder sandwichOrder) {
        this.sandwichOrder = sandwichOrder;
    }
}
