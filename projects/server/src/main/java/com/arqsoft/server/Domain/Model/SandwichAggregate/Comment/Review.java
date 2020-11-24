package com.arqsoft.server.Domain.Model.SandwichAggregate.Comment;

import com.arqsoft.server.Domain.Interface.Entity;
import com.arqsoft.server.Domain.Model.UserAggregate.User;

public class Review extends Comment implements Entity {

    private Rating rating;

    public Review(Id id, User user, Content content, Title title, Rating rating) {
        super(id, user, content, title);
        this.rating = rating;
    }

    public Review(User user, Content content, Title title, Rating rating) {
        super(user, content, title);
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }
}
