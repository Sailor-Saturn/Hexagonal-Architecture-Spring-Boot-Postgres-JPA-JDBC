package com.arqsoft.server.Domain.Model.SandwichAggregate.Comment;

import com.arqsoft.server.Domain.Interface.ValueObject;

public class Id implements ValueObject {

    private long id;

    public Id(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
