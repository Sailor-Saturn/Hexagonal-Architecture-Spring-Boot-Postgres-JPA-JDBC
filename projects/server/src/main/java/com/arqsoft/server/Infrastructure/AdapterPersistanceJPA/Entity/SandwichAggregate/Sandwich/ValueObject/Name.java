package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Name {

    private String name;

    protected Name() {}

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
