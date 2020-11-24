package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Description {

    private String description;

    protected Description() {};

    public Description(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
