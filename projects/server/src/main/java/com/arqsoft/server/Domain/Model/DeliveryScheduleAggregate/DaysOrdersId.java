package com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

public class DaysOrdersId implements ValueObject {

    private Long Id;

    public DaysOrdersId(Long id) {
        Validate.isTrue(id > 0L, "Id must be greater than zero. Received: %d", id);
        Id = id;
    }

    public Long getId() {
        return Id;
    }
}
