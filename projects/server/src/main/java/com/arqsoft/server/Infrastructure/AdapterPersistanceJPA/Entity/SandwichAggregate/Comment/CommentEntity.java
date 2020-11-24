package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.ValueObject.Content;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.ValueObject.Title;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CommentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long Id;

    private Content content;
    private Title title;

    @OneToOne
    private UserEntity user;

    protected CommentEntity() {};

    public CommentEntity(long id, UserEntity user, Content content, Title title) {
        this.Id = id;
        this.user = user;
        this.content = content;
        this.title = title;
    }

    public CommentEntity(UserEntity user, Content content, Title title) {
        this.user = user;
        this.content = content;
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public Title getTitle() {
        return title;
    }

    public Long getId() {
        return Id;
    }

    public UserEntity getUser() {
        return user;
    }
}
