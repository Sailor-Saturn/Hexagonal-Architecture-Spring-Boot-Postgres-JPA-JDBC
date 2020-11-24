package com.arqsoft.server.Application.Controller.Dto.Request.Sandwich;

public class RequestReviewDTO {

    private String title;
    private String content;
    private int rating;
    private long userId;

    protected RequestReviewDTO() {}

    public RequestReviewDTO(String title, String content, int rating, long userId) {
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }

    public long getUserId() {
        return userId;
    }
}
