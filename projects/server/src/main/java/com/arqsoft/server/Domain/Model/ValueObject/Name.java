package com.arqsoft.server.Domain.Model.ValueObject;

import org.apache.commons.lang3.Validate;
import utils.RegexValidator;

public class Name {
    private String name;

    public Name(String name) {
        Validate.notEmpty(name);
        Validate.notNull(name);
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
