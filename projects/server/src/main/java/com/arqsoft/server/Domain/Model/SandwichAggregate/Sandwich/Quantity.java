package com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class Quantity implements ValueObject {

    private int quantity;

    public Quantity(int quantity) {
        Validate.isTrue(quantity >= 0, "The value of quantity must be at least 0: %d", quantity);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return quantity == quantity1.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
