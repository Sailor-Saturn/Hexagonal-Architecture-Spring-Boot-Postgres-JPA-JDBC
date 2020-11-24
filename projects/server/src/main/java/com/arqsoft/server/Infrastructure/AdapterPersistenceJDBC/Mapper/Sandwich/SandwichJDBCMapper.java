package com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Mapper.Sandwich;

import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Id;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.SandwichType;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.Sandwich.SandwichJDBC;


import java.util.ArrayList;
import java.util.List;

public class SandwichJDBCMapper {
    public static SandwichJDBC DomainEntityToJDBCEntityWithId(Sandwich sandwich) {
        return new SandwichJDBC(
                sandwich.getId().getId(),
                sandwich.getName().getName(),
                sandwich.getDescription().getDescription(),
                sandwich.getQuantity().getQuantity(),
                sandwich.getType().toString()
        );
    }

    public static SandwichJDBC DomainEntityToJDBCEntityWithoutId(Sandwich sandwich) {
        return new SandwichJDBC(
                sandwich.getName().getName(),
                sandwich.getDescription().getDescription(),
                sandwich.getQuantity().getQuantity(),
                sandwich.getType().toString()
        );
    }

    public static SandwichJDBC DomainEntityToJDBCEntity(Sandwich sandwich) {
        // The domain entity does not have an id yet. Create a JPA entity also without id
        if (sandwich.getId() == null)  {
            return DomainEntityToJDBCEntityWithoutId(sandwich);
        }

        // Create a JPA entity with ID
        return DomainEntityToJDBCEntityWithId(sandwich);
    }

    private static SandwichType getSandwichTypeFromString(String sandwichType) {
        if (sandwichType.equals("SALTY")) {
            return SandwichType.SALTY;
        } else if (sandwichType.equals("SWEET")) {
            return SandwichType.SWEET;
        }
        return null;
    }

    public static Sandwich JDBCEntityToDomainEntity(SandwichJDBC sandwichEntity) {
        return new Sandwich(
                new Id(sandwichEntity.getId()),
                new com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Description(sandwichEntity.getDescription()),
                new com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Name(sandwichEntity.getName()),
                new com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Quantity(sandwichEntity.getQuantity()),
                getSandwichTypeFromString(sandwichEntity.getType())
        );
    }

    public static List<Sandwich> JDBCEntitiesToDomainEntities(List<SandwichJDBC> sandwichEntities) {
        List<Sandwich> sandwichList = new ArrayList<>();
        sandwichEntities.forEach(sandwichEntity -> {
            sandwichList.add(JDBCEntityToDomainEntity(sandwichEntity));
        });
        return sandwichList;
    }
}
