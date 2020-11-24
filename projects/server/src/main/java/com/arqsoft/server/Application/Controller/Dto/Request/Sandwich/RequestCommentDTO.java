package com.arqsoft.server.Application.Controller.Dto.Request.Sandwich;


public class RequestCommentDTO {

    private String title;
    private String content;

    private long userId;

    protected RequestCommentDTO() {}

    public RequestCommentDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public long getUserId() {
        return userId;
    }
}
