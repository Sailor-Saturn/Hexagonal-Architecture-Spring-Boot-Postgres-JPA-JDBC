package com.arqsoft.server.Infrastructure.Mapper.Sandwich;

import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Id;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.SandwichType;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.SandwichEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.ValueObject.Description;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.ValueObject.Name;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.ValueObject.Quantity;

import java.util.ArrayList;
import java.util.List;

public class SandwichMapper {
    public static SandwichEntity DomainEntityToJPAEntityWithId(Sandwich sandwich) {
        return new SandwichEntity(
                sandwich.getId().getId(),
                new Name(sandwich.getName().getName()),
                new Description(sandwich.getDescription().getDescription()),
                new Quantity(sandwich.getQuantity().getQuantity()),
                sandwich.getType().toString(),
                CommentMapper.DomainEntitiesToJPAEntities(sandwich.getCommentList())
        );
    }

    public static SandwichEntity DomainEntityToJPAEntityWithoutId(Sandwich sandwich) {
        return new SandwichEntity(
                new Name(sandwich.getName().getName()),
                new Description(sandwich.getDescription().getDescription()),
                new Quantity(sandwich.getQuantity().getQuantity()),
                sandwich.getType().toString(),
                CommentMapper.DomainEntitiesToJPAEntities(sandwich.getCommentList())
        );
    }

    public static SandwichEntity DomainEntityToJPAEntity(Sandwich sandwich) {
        // The domain entity does not have an id yet. Create a JPA entity also without id
        if (sandwich.getId() == null)  {
            return DomainEntityToJPAEntityWithoutId(sandwich);
        }

        // Create a JPA entity with ID
        return DomainEntityToJPAEntityWithId(sandwich);
    }

    private static SandwichType getSandwichTypeFromString(String sandwichType) {
        if (sandwichType.equals("SALTY")) {
            return SandwichType.SALTY;
        } else if (sandwichType.equals("SWEET")) {
            return SandwichType.SWEET;
        }
        return null;
    }

    public static Sandwich JPAEntityToDomainEntity(SandwichEntity sandwichEntity) {
        return new Sandwich(
                new Id(sandwichEntity.getId()),
                new com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Description(sandwichEntity.getDescription().getDescription()),
                new com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Name(sandwichEntity.getName().getName()),
                new com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Quantity(sandwichEntity.getQuantity().getQuantity()),
                getSandwichTypeFromString(sandwichEntity.getType()),
                CommentMapper.JPAEntityToDomainEntity(sandwichEntity.getCommentList())
        );
    }

    public static List<Sandwich> JPAEntitiesToDomainEntities(List<SandwichEntity> sandwichEntities) {
        List<Sandwich> sandwichList = new ArrayList<>();
        sandwichEntities.forEach(sandwichEntity -> {
            sandwichList.add(JPAEntityToDomainEntity(sandwichEntity));
        });
        return sandwichList;
    }
}
