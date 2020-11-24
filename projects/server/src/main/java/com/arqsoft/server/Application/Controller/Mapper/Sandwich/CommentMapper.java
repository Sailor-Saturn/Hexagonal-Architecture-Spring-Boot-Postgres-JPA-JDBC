package com.arqsoft.server.Application.Controller.Mapper.Sandwich;

import com.arqsoft.server.Application.Controller.Dto.Request.Sandwich.RequestCommentDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.CommentDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.CommentUserDTO;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.*;
import com.arqsoft.server.Domain.Model.UserAggregate.User;

import java.util.ArrayList;
import java.util.List;

public class CommentMapper {
    public static CommentDTO DomainEntityToDTO(Comment comment) {
        CommentUserDTO commentUserDTO = new CommentUserDTO(
                comment.getUser().getUserId().getId(),
                comment.getUser().getUsername().getName()
        );
        return new CommentDTO(
                comment.getTitle().getTitle(),
                comment.getContent().getContent(),
                commentUserDTO
        );
    }

    public static List<CommentDTO> DomainEntitiesToDTO(List<Comment> commentList) {
        List<CommentDTO> commentDTOList = new ArrayList<>();

        commentList.forEach(comment -> {
            commentDTOList.add(DomainEntityToDTO(comment));
        });

        return commentDTOList;
    }

    public static Comment DTOToDomainEntity(RequestCommentDTO commentDTO, User user) {
          return new Comment(
            user,
            new Content(commentDTO.getContent()),
            new Title(commentDTO.getTitle())
        );
    }
}
