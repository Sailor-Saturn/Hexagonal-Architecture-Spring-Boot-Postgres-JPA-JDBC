package com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.Sandwich;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("comment")
public class Comment {

    @Id
    private Long id;

    private String content;

    private String title;

    private long user_id;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public long getUser_id() {
        return user_id;
    }

    protected Comment() {}

    public Comment(Long id, String content, String title, long user_id) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.user_id = user_id;
    }

    public Comment(String content, String title, long user_id) {
        this.content = content;
        this.title = title;
        this.user_id = user_id;
    }
}
