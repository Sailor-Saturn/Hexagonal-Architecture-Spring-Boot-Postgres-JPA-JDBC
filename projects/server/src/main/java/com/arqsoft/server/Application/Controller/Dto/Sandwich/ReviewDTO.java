package com.arqsoft.server.Application.Controller.Dto.Sandwich;

public class ReviewDTO {
    private String title;
    private String content;
    private int rating;
    private int minimumRating;
    private int maximumRating;

    protected ReviewDTO() {};

    public ReviewDTO(String title, String content, int rating, int minimumRating, int maximumRating) {
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.minimumRating = minimumRating;
        this.maximumRating = maximumRating;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getMinimumRating() {
        return minimumRating;
    }

    public int getMaximumRating() {
        return maximumRating;
    }
}
