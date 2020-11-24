package com.arqsoft.server.Infrastructure.Mapper.Sandwich;

import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Comment;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Id;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Rating;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Review;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.CommentEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.Review.ReviewEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.ValueObject.Content;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.ValueObject.Title;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserEntity;
import com.arqsoft.server.Infrastructure.Mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

public class CommentMapper {
    public static CommentEntity DomainEntityToJPAEntityWithoutId(Comment comment) {
        UserEntity user = UserMapper.DomainEntityToJpaEntityWithId(comment.getUser());
        if (comment instanceof Review) {
            Review reviewInstance = (Review) comment;
            return new ReviewEntity(
                    user,
                    new Content(comment.getContent().getContent()),
                    new Title(comment.getTitle().getTitle()),
                    new com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.Review.ValueObject.Rating(
                            reviewInstance.getRating().getRating(),
                            reviewInstance.getRating().getMinimumRating(),
                            reviewInstance.getRating().getMaximumRating()
                    )
            );
        }
        return new CommentEntity(
                user,
                new Content(comment.getContent().getContent()),
                new Title(comment.getTitle().getTitle()));
    }

    public static CommentEntity DomainEntityToJPAEntityWithId(Comment comment) {
        UserEntity user = UserMapper.DomainEntityToJpaEntityWithId(comment.getUser());
        if (comment instanceof Review) {
            Review reviewInstance = (Review) comment;
            return new ReviewEntity(
                    comment.getId().getId(),
                    user,
                    new Content(comment.getContent().getContent()),
                    new Title(comment.getTitle().getTitle()),
                    new com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Comment.Review.ValueObject.Rating(
                            reviewInstance.getRating().getRating(),
                            reviewInstance.getRating().getMinimumRating(),
                            reviewInstance.getRating().getMaximumRating()
                    )
            );
        }
        return new CommentEntity(
                comment.getId().getId(),
                user,
                new Content(comment.getContent().getContent()),
                new Title(comment.getTitle().getTitle()));
    }

    public static CommentEntity DomainEntityToJPAEntity(Comment comment) {
        if (comment.getId() == null) {
            return DomainEntityToJPAEntityWithoutId(comment);
        }

        return DomainEntityToJPAEntityWithId(comment);
    }

    public static List<CommentEntity> DomainEntitiesToJPAEntities(List<Comment> commentList) {
        List<CommentEntity> commentEntities = new ArrayList<>();

        commentList.forEach(comment -> {
            commentEntities.add(DomainEntityToJPAEntity(comment));
        });

        return commentEntities;
    }

    public static List<Comment> JPAEntityToDomainEntity(List<CommentEntity> commentEntities) {
        List<Comment> commentList = new ArrayList<>();

        commentEntities.forEach(commentEntity -> {
            User user = UserMapper.JPAEntityToDomainEntity(commentEntity.getUser());
            Comment commentToAdd = null;
            if (commentEntity instanceof ReviewEntity) {
                ReviewEntity reviewEntity = (ReviewEntity) commentEntity;
                Rating rating = new Rating(
                        reviewEntity.getRating().getRating()
                );
                commentToAdd = new Review(
                        new Id(reviewEntity.getId()),
                        user,
                        new com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Content(reviewEntity.getContent().getContent()),
                        new com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Title(reviewEntity.getTitle().getTitle()),
                        rating
                );
            } else {
                commentToAdd = new Comment(
                        new Id(commentEntity.getId()),
                        user,
                        new com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Content(commentEntity.getContent().getContent()),
                        new com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Title(commentEntity.getTitle().getTitle()));
            }
            commentList.add(commentToAdd);
        });

        return commentList;
    }
}
