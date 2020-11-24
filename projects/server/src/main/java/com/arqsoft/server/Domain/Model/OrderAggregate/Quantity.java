package com.arqsoft.server.Domain.Model.OrderAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

public class Quantity implements ValueObject {

    private int value;

    public Quantity(int value) {
        Validate.isTrue(value > 0, "Quantity value must be greater than 0. Received: %s", value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
