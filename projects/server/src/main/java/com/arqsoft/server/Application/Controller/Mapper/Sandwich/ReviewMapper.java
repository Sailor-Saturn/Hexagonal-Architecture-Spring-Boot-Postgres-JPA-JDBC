package com.arqsoft.server.Application.Controller.Mapper.Sandwich;

import com.arqsoft.server.Application.Controller.Dto.Request.Sandwich.RequestReviewDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.ReviewDTO;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Content;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Rating;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Review;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Title;
import com.arqsoft.server.Domain.Model.UserAggregate.User;

public class ReviewMapper {
    public static Review DTOToDomainEntity(RequestReviewDTO reviewDTO, User user) {
        // Comment has rating, so it is a review
        return new Review(
                user,
                new Content(reviewDTO.getContent()),
                new Title(reviewDTO.getTitle()),
                new Rating(
                        reviewDTO.getRating()
                )
        );
    }

    public static ReviewDTO DomainEntityToDTO(Review review) {
        return new ReviewDTO(
                review.getTitle().getTitle(),
                review.getContent().getContent(),
                review.getRating().getRating(),
                review.getRating().getMinimumRating(),
                review.getRating().getMaximumRating()
        );
    }
}
