package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.CommentEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.ValueObject.Description;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.ValueObject.Name;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.ValueObject.Quantity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Sandwich")
public class SandwichEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Name name;

    private Description description;

    private Quantity quantity;

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CommentEntity> commentList;

    protected SandwichEntity() {}

    public SandwichEntity(Long id, Name name, Description description, Quantity quantity, String type, List<CommentEntity> commentList) {
        this.Id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
        this.commentList = commentList;
    }

    public SandwichEntity(Name name, Description description, Quantity quantity, String type, List<CommentEntity> commentList) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
        this.commentList = commentList;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public Long getId() {
        return Id;
    }

    public List<CommentEntity> getCommentList() {
        return commentList;
    }
}
