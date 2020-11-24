package com.arqsoft.server.Service.Adapter;

import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Comment;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Comment.Review;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.*;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Domain.Port.OrderPersistencePort;
import com.arqsoft.server.Domain.Port.SandwichPersistencePort;
import com.arqsoft.server.Infrastructure.PersistencePortFactory.SandwichPersistencePortFactory;
import com.arqsoft.server.Service.Port.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class SandwichServiceAdapter implements SandwichService {

    private SandwichPersistencePort sandwichPersistencePort;

    @Autowired
    private OrderPersistencePort orderPersistencePort;

    @Autowired
    private SandwichPersistencePortFactory sandwichPersistencePortFactory;

    @PostConstruct
    public void setUserPersistencePort() {
        this.sandwichPersistencePort = sandwichPersistencePortFactory.retrieveSandwichPersistencePort();
    }

    @Override
    public Sandwich createSandwich(Sandwich sandwich) {
        return sandwichPersistencePort.saveSandwich(sandwich);
    }

    public List<Sandwich> getAllSandwiches() {
        return sandwichPersistencePort.getAll();
    }

    private boolean userOrderedSandwich(Sandwich sandwich, User user) {
        List<Order> userOrders = orderPersistencePort.findByUser(user);

        for (Order order : userOrders) {
            if (order.hasSandwich(sandwich)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Comment addCommentToSandwich(long sandwichId, User user, Comment comment) {

        Optional<Sandwich> optionalSandwich = getSandwichById(sandwichId);

        if (!optionalSandwich.isPresent()) {
            throw new IllegalArgumentException("There's no sandwich with the associated id");
        }

        Sandwich sandwich = optionalSandwich.get();

        if (comment instanceof Review) {
            // User has not ordered a sandwich. He can not review it
            if (!userOrderedSandwich(sandwich, user)) {
                throw new IllegalArgumentException("User can't review a sandwich that he has not ordered");
            }
        }

        sandwich.addComment(comment);
        sandwichPersistencePort.saveSandwich(sandwich);
        return comment;
    }

    @Override
    public Sandwich changeSandwich(Sandwich sandwich, Integer quantity, String description, String name, SandwichType type) {
        if (quantity != null) {
            sandwich.setQuantity(new Quantity(quantity));
        }

        if (description != null) {
            sandwich.setDescription(new Description(description));
        }

        if (name != null) {
            sandwich.setName(new Name(name));
        }

        if (type != null) {
            sandwich.setType(type);
        }

        return sandwichPersistencePort.saveSandwich(sandwich);
    }


    @Override
    public void deleteSandwich(long id) {
        sandwichPersistencePort.deleteById(id);
    }

    @Override
    public Optional<Sandwich> getSandwichById(long id) {
        return sandwichPersistencePort.findById(id);
    }
}
