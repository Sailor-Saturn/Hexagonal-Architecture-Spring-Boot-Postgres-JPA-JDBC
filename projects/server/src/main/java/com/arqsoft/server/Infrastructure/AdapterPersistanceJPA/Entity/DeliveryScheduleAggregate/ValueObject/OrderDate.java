package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class OrderDate {

    @Column(name ="orderDate")
    private Date orderDate;

    protected OrderDate() { }

    public OrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDate orderDate1 = (OrderDate) o;
        return Objects.equals(orderDate, orderDate1.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDate);
    }
}
