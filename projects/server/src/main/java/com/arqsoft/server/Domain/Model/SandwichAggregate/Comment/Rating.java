package com.arqsoft.server.Domain.Model.SandwichAggregate.Comment;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class Rating implements ValueObject {

    private int rating;
    private final int minimumRating = 1;
    private final int maximumRating = 5;

    public Rating(int rating) {
        Validate.inclusiveBetween(minimumRating, maximumRating, rating, "Rating must be between minimum and maximum rating." +
                "Received rating %d with minimum %d and maximum %d", rating, minimumRating, maximumRating);

        this.rating = rating;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return rating == rating1.rating &&
                minimumRating == rating1.minimumRating &&
                maximumRating == rating1.maximumRating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, minimumRating, maximumRating);
    }
}
