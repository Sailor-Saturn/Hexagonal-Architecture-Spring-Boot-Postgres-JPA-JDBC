package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.Review.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Rating {
    private int rating;
    private int minimumRating;
    private int maximumRating;

    protected Rating() {}

    public Rating(int rating, int minimumRating, int maximumRating) {
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
