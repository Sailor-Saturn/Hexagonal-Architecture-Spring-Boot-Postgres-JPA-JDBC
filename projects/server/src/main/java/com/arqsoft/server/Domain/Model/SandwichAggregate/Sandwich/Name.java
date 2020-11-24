package com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class Name implements ValueObject {

    private String name;

    public Name(String name) {
        Validate.notBlank(name, "Description must not be empty or only whitespaces. Value is: %s", name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
