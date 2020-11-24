package com.arqsoft.server.Domain.Model.UserAggregate;

import org.apache.commons.lang3.Validate;

public class UserId {

    private Long id;

    public UserId(Long id) {
        Validate.isTrue(id > 0L, "Id must be greater than zero. Received: %d", id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
