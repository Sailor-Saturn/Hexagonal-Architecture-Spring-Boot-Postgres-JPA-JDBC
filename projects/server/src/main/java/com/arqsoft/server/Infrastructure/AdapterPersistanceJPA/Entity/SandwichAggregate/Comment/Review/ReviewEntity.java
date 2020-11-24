package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.Review;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.CommentEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.Review.ValueObject.Rating;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.ValueObject.Content;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.ValueObject.Title;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class ReviewEntity extends CommentEntity {
    private Rating rating;

    protected ReviewEntity() {};

    public ReviewEntity(UserEntity user, Content content, Title title, Rating rating) {
        super(user, content, title);
        this.rating = rating;
    }

    public ReviewEntity(long id, UserEntity user, Content content, Title title, Rating rating) {
        super(id, user, content, title);
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }
}
