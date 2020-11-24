package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.ValueObject;

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
