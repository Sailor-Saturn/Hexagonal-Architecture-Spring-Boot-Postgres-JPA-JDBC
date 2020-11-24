package com.arqsoft.server.Domain.Model.SandwichAggregate.Comment;

import com.arqsoft.server.Domain.Interface.Entity;
import com.arqsoft.server.Domain.Model.UserAggregate.User;

public class Comment implements Entity {

    private Id id;
    private Content content;
    private Title title;
    private User user;

    public Comment(Id id, User user, Content content, Title title) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.title = title;
    }

    public Comment(User user, Content content, Title title) {
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

    public Id getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
