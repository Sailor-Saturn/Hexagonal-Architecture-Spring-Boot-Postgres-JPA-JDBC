package com.arqsoft.server.Application.Controller.Dto.Sandwich;

public class CommentWithRatingDTO extends CommentDTO {
    private int rating;
    private int minimumRating;
    private int maximumRating;

    public CommentWithRatingDTO(String title, String content, CommentUserDTO user, int rating, int minimumRating, int maximumRating) {
        super(title, content, user);
        this.rating = rating;
        this.minimumRating = minimumRating;
        this.maximumRating = maximumRating;
    }

    public int getRating() {
        return rating;
    }

    public int getMinimumRating() {
        return minimumRating;
    }

    public int getMaximumRating() {
        return maximumRating;
    }
}
