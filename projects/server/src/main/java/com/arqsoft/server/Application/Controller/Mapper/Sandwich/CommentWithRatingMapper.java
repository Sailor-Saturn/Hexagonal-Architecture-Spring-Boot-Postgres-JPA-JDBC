package com.arqsoft.server.Application.Controller.Mapper.Sandwich;

import com.arqsoft.server.Application.Controller.Dto.Sandwich.CommentDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.CommentUserDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.CommentWithRatingDTO;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Comment;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Review;

import java.util.ArrayList;
import java.util.List;

public class CommentWithRatingMapper {
    public static CommentDTO DomainEntityToDTO(Comment comment) {
        CommentUserDTO commentUserDTO = new CommentUserDTO(comment.getUser().getUserId().getId(), comment.getUser().getUsername().getName());
        if (comment instanceof Review) {
            Review reviewInstance = (Review) comment;
            return new CommentWithRatingDTO(
                    reviewInstance.getTitle().getTitle(),
                    reviewInstance.getContent().getContent(),
                    commentUserDTO,
                    reviewInstance.getRating().getRating(),
                    reviewInstance.getRating().getMinimumRating(),
                    reviewInstance.getRating().getMaximumRating()
            );
        }
        // Comment is not instance of review, so it is instance of comment
        return new CommentDTO(
                comment.getTitle().getTitle(),
                comment.getContent().getContent(),
                commentUserDTO
        );
    }

    public static List<CommentDTO> DomainEntitiesToDTO(List<Comment> comments) {
        List<CommentDTO> commentWithRatingDTOS = new ArrayList<>();

        comments.forEach(comment -> {
            commentWithRatingDTOS.add(DomainEntityToDTO(comment));
        });

        return commentWithRatingDTOS;
    }
}
