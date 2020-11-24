package com.arqsoft.server.Domain.Model.SandwichAggregate.Comment;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class Content implements ValueObject {

    private String content;

    public Content(String content) {
        Validate.notBlank(content, "Content must not be empty or only whitespaces. Value is: %s", content);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content1 = (Content) o;
        return content.equals(content1.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
