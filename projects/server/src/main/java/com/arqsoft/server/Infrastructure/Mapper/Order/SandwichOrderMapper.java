package com.arqsoft.server.Infrastructure.Mapper.Order;

import com.arqsoft.server.Domain.Model.OrderAggregate.SandwichOrder;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.ValueObject.Quantity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.SandwichEntity;
import com.arqsoft.server.Infrastructure.Mapper.Sandwich.SandwichMapper;

import java.util.HashMap;
import java.util.Map;

public class SandwichOrderMapper {
    public static Map<SandwichEntity, Integer> DomainEntitiesToJPAEntities(SandwichOrder sandwichOrder) {
        Map<SandwichEntity, Integer> map = new HashMap<>();
        for (Map.Entry<Sandwich, com.arqsoft.server.Domain.Model.OrderAggregate.Quantity> entry : sandwichOrder.getSandwichOrder().entrySet()){
            SandwichEntity sandwichEntity = SandwichMapper.DomainEntityToJPAEntity(entry.getKey());
            Integer quantity = entry.getValue().getValue();
            map.put(sandwichEntity,quantity);
        }
        return map;
    }

    public static SandwichOrder JpaEntityToDomainEntity(Map<SandwichEntity, Integer> sandwichOrder) {
        SandwichOrder sandwichOrderFinal = new SandwichOrder();
        for(Map.Entry<SandwichEntity,Integer> entry : sandwichOrder.entrySet()){
            Sandwich sandwich = SandwichMapper.JPAEntityToDomainEntity(entry.getKey());
            com.arqsoft.server.Domain.Model.OrderAggregate.Quantity quantity = new com.arqsoft.server.Domain.Model.OrderAggregate.Quantity(entry.getValue().intValue());
            sandwichOrderFinal.addSandwichQuantity(sandwich,quantity);
        }
        return sandwichOrderFinal;
    }
}
