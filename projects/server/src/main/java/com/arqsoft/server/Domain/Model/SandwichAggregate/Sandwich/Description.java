package com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class Description implements ValueObject {

    private String description;

    public Description(String description) {
        Validate.notBlank(description, "Description must not be empty or only whitespaces. Value is: %s", description);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
