package com.arqsoft.server.Domain.Model.OrderAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

public class OrderId implements ValueObject {

    private Long id;

    public OrderId(Long id) {
        Validate.isTrue(id > 0L, "Id must be greater than zero. Received: %d", id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
