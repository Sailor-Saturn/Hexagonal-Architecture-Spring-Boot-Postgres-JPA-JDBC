package com.arqsoft.server.Application.Controller.Mapper.Order;

import com.arqsoft.server.Application.Controller.Dto.Request.Order.RequestSandwichOrderDTO;
import com.arqsoft.server.Application.Controller.Dto.Response.Order.ResponseSandwichOrderDTO;
import com.arqsoft.server.Domain.Model.OrderAggregate.Quantity;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.SandwichEntity;
import com.arqsoft.server.Infrastructure.Mapper.Sandwich.SandwichMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SandwichOrderMapper {

    public static Map<Long, Quantity> ResponseDTOListtoMap(List<RequestSandwichOrderDTO> sandwichOrder){
        Map<Long, Quantity> map = new HashMap<>();

        for (int i = 0; i < sandwichOrder.size(); i++) {
            map.put(sandwichOrder.get(i).getSandwichId(),new Quantity(sandwichOrder.get(i).getQuantity()));
        }

        return map;
    }

    public static List<ResponseSandwichOrderDTO> EntityMapToList(Map<Sandwich, Quantity> sandwichOrder) {
        List<ResponseSandwichOrderDTO> list = new ArrayList<>();
        for (Map.Entry<Sandwich, Quantity> entry : sandwichOrder.entrySet()){
            ResponseSandwichOrderDTO responseSandwichOrderDTO = new ResponseSandwichOrderDTO(entry.getKey().getId().getId(),entry.getValue().getValue());
            list.add(responseSandwichOrderDTO);
        }
        return list;
    }
}
