package com.arqsoft.server.Application.Controller.Mapper.Sandwich;

import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.SandwichType;

public class SandwichTypeMapper {
    public static SandwichType StringToDomainEntity(String type) {
        if (type == null) {
            return null;
        }

        if (type.equals("sweet")) {
            return SandwichType.SWEET;
        } else if (type.equals("salty")) {
            return SandwichType.SALTY;
        }
        return null;
    }
}
