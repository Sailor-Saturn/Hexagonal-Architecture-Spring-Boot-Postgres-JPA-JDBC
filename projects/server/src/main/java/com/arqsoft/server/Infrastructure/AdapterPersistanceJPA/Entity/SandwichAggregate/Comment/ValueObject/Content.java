package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Content {

    private String content;

    protected Content() {};

    public Content(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
