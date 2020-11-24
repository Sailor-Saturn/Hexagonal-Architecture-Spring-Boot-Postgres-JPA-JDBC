package com.arqsoft.server.Domain.Model.SandwichAggregate.Comment;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class Title implements ValueObject {

    private String title;

    public Title(String title) {
        Validate.notBlank(title, "Title must not be empty or only whitespaces. Value is: %s", title);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return title.equals(title1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
