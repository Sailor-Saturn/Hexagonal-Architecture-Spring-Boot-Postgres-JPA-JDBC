package com.arqsoft.server.Service.Port;

import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Comment;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.SandwichType;
import com.arqsoft.server.Domain.Model.UserAggregate.User;

import java.util.List;
import java.util.Optional;

public interface SandwichService {
    Sandwich createSandwich(Sandwich sandwich);

    Optional<Sandwich> getSandwichById(long id);

    List<Sandwich> getAllSandwiches();

    Comment addCommentToSandwich(long sandwichId, User user, Comment comment);

    Sandwich changeSandwich(Sandwich sandwich, Integer quantity, String description, String name, SandwichType type);

    void deleteSandwich(long id);
}
