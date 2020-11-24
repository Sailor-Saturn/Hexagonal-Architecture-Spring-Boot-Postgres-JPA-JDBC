package com.arqsoft.server.Application.Controller.Adapter;

import com.arqsoft.server.Application.Controller.Dto.Request.Sandwich.RequestCommentDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.Sandwich.RequestChangeSandwichDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.Sandwich.RequestReviewDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.Sandwich.RequestSandwichDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.CommentDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.ReviewDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.SandwichDTO;
import com.arqsoft.server.Application.Controller.Mapper.Sandwich.CommentMapper;
import com.arqsoft.server.Application.Controller.Mapper.Sandwich.ReviewMapper;
import com.arqsoft.server.Application.Controller.Mapper.Sandwich.SandwichMapper;
import com.arqsoft.server.Application.Controller.Mapper.Sandwich.SandwichTypeMapper;
import com.arqsoft.server.Application.Controller.Port.SandwichControllerPort;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Comment;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Review;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.SandwichType;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Service.Port.SandwichService;
import com.arqsoft.server.Service.Port.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("sandwich")
public class SandwichControllerAdapter implements SandwichControllerPort {

    @Autowired
    private SandwichService sandwichService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SandwichDTO>> getSandwiches() {
        List<Sandwich> allSandwiches = sandwichService.getAllSandwiches();

        List<SandwichDTO> dtoList = SandwichMapper.DomainEntitiesToDTO(allSandwiches);
        return ResponseEntity.ok().body(dtoList);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<SandwichDTO> getSandwichById(@PathVariable("id") long id) {
        Optional<Sandwich> sandwich = sandwichService.getSandwichById(id);

        if (!sandwich.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        SandwichDTO responseDTO = SandwichMapper.DomainEntityToDTO(sandwich.get());
        return ResponseEntity.ok().body(responseDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SandwichDTO> createSandwich(@RequestBody RequestSandwichDTO requestSandwichDTO) {

        Sandwich domainEntity = null;
        try {
            domainEntity = SandwichMapper.DTOToDomainEntity(requestSandwichDTO);
        } catch (IllegalArgumentException | NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Sandwich createdSandwich = sandwichService.createSandwich(domainEntity);

        SandwichDTO responseDTO = SandwichMapper.DomainEntityToDTO(createdSandwich);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<SandwichDTO> changeSandwichQuantity(@RequestBody RequestChangeSandwichDTO requestChangeSandwichDTO, @PathVariable("id") long id) {
        Optional<Sandwich> sandwich = sandwichService.getSandwichById(id);

        if (!sandwich.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        SandwichType newSandwichType = SandwichTypeMapper.StringToDomainEntity(requestChangeSandwichDTO.getType());

        Sandwich updatedSandwich = sandwichService.changeSandwich(
                sandwich.get(),
                requestChangeSandwichDTO.getQuantity(),
                requestChangeSandwichDTO.getDescription(),
                requestChangeSandwichDTO.getName(),
                newSandwichType
        );

        SandwichDTO responseDTO = SandwichMapper.DomainEntityToDTO(updatedSandwich);

        return ResponseEntity.ok(responseDTO);
    }

    @RequestMapping(value="/{id}/comment", method = RequestMethod.POST)
    public ResponseEntity<CommentDTO> addCommentToSandwich(@RequestBody RequestCommentDTO commentDTO, @PathVariable("id") long id) {
        Optional<User> userEntity = userService.getUser(commentDTO.getUserId());

        if (!userEntity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Comment commentEntity = CommentMapper.DTOToDomainEntity(commentDTO, userEntity.get());

        Comment addedComment = null;
        try {
            addedComment = sandwichService.addCommentToSandwich(id, userEntity.get(), commentEntity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(CommentMapper.DomainEntityToDTO(addedComment));
    }

    @RequestMapping(value="/{id}/review", method = RequestMethod.POST)
    public ResponseEntity<ReviewDTO> addReviewToSandwich(@RequestBody RequestReviewDTO reviewDTO, @PathVariable("id") long id) {
        Optional<User> userEntity = userService.getUser(reviewDTO.getUserId());

        if (!userEntity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Review reviewEntity = ReviewMapper.DTOToDomainEntity(reviewDTO, userEntity.get());

        Comment addedReview = null;
        try {
            addedReview = sandwichService.addCommentToSandwich(id, userEntity.get(), reviewEntity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        ReviewDTO responseData = ReviewMapper.DomainEntityToDTO((Review) addedReview);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSandwich(@PathVariable("id") long id) {
        sandwichService.deleteSandwich(id);

        return ResponseEntity.noContent().build();
    }
}
