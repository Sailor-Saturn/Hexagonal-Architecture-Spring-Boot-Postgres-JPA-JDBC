package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Quantity {

    private int quantity;

    protected Quantity() {};

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
