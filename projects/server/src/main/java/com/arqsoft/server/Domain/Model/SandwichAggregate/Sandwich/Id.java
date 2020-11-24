package com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich;

import com.arqsoft.server.Domain.Interface.ValueObject;

import java.util.Objects;

public class Id implements ValueObject {

    private long id;

    public Id(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id1 = (Id) o;
        return id == id1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
