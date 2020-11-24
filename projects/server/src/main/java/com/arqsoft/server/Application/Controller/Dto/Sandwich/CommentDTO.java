package com.arqsoft.server.Application.Controller.Dto.Sandwich;

public class CommentDTO {

    private String title;
    private String content;
    private CommentUserDTO user;

    public CommentDTO(String title, String content, CommentUserDTO commentUserDTO) {
        this.title = title;
        this.content = content;
        this.user = commentUserDTO;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public CommentUserDTO getUser() {
        return user;
    }
}
