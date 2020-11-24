package com.arqsoft.server.Domain.Model.DayScheduleAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

public class DayScheduleId implements ValueObject {

    private Long Id;

    public DayScheduleId(Long id) {
        Validate.isTrue(id > 0L, "Id must be greater than zero. Received: %d", id);
        Id = id;
    }

    public Long getId() {
        return Id;
    }
}
