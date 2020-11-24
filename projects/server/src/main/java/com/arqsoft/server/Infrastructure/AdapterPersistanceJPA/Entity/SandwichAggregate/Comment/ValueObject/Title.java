package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Title {
    private String title;

    protected Title() {}

    public Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
