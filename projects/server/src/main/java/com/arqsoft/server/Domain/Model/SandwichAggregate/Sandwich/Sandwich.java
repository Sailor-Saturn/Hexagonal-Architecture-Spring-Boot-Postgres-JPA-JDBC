package com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich;

import com.arqsoft.server.Domain.Interface.Entity;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Comment;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sandwich implements Entity {

    private Id id;
    private Description description;
    private Name name;
    private SandwichType type;
    private Quantity quantity;
    private List<Comment> commentList;

    public Sandwich(Id id, Description description, Name name, Quantity quantity, SandwichType type) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.commentList = new ArrayList<>();
    }

    public Sandwich(Id id, Description description, Name name, Quantity quantity, SandwichType type, List<Comment> commentList) {
        Validate.notNull(id);
        Validate.notNull(description);
        Validate.notNull(name);
        Validate.notNull(quantity);
        Validate.notNull(type);
        Validate.notNull(commentList);

        this.id = id;
        this.description = description;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.commentList = commentList;
    }

    public Sandwich(Description description, Name name, SandwichType type) {
        Validate.notNull(description);
        Validate.notNull(name);
        Validate.notNull(type);

        this.description = description;
        this.name = name;
        this.quantity = new Quantity(0);
        this.type = type;
        this.commentList = new ArrayList<>();
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

    public Description getDescription() {
        return description;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Name getName() {
        return name;
    }

    public SandwichType getType() {
        return type;
    }

    public Id getId() {
        return id;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setType(SandwichType type) {
        this.type = type;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sandwich sandwich = (Sandwich) o;
        return Objects.equals(id, sandwich.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
