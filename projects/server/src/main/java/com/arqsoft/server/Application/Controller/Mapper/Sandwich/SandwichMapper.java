package com.arqsoft.server.Application.Controller.Mapper.Sandwich;

import com.arqsoft.server.Application.Controller.Dto.Request.Sandwich.RequestSandwichDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.SandwichDTO;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.*;

import java.util.ArrayList;
import java.util.List;

public class SandwichMapper {
    private static SandwichType getSandwichTypeFromString(String type) {
        if (type.equals("salty")) {
            return SandwichType.SALTY;
        } else if (type.equals("sweet")) {
            return SandwichType.SWEET;
        }
        return null;
    }

    public static Sandwich DTOToDomainEntity(RequestSandwichDTO sandwichDTO) {
        return new Sandwich(
                new Description(sandwichDTO.getDescription()),
                new Name(sandwichDTO.getName()),
                getSandwichTypeFromString(sandwichDTO.getType()));
    }

    public static SandwichDTO DomainEntityToDTO(Sandwich domainEntity) {
        return new SandwichDTO(
                domainEntity.getId().getId(),
                domainEntity.getName().getName(),
                domainEntity.getDescription().getDescription(),
                domainEntity.getQuantity().getQuantity(),
                domainEntity.getType().toString(),
                CommentWithRatingMapper.DomainEntitiesToDTO(domainEntity.getCommentList())
        );
    }

    public static List<SandwichDTO> DomainEntitiesToDTO(List<Sandwich> domainEntities) {
        List<SandwichDTO> sandwichDTOList = new ArrayList<>();

        domainEntities.forEach(sandwich -> {
            sandwichDTOList.add(DomainEntityToDTO(sandwich));
        });

        return sandwichDTOList;
    }
}
