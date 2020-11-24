package com.arqsoft.server.Application.Controller.Dto.Sandwich;

public class CommentUserDTO {

    private long id;
    private String name;

    public CommentUserDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
