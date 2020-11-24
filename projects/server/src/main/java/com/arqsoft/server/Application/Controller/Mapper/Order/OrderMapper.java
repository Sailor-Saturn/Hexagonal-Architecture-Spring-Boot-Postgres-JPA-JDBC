package com.arqsoft.server.Application.Controller.Mapper.Order;


import com.arqsoft.server.Application.Controller.Dto.Response.Order.ResponseOrderDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.Order.RequestOrderDTO;
import com.arqsoft.server.Application.Controller.Dto.Response.Order.ResponseSlotDTO;
import com.arqsoft.server.Application.Controller.Mapper.UserMapper;
import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Domain.Model.OrderAggregate.SandwichOrder;
import com.arqsoft.server.Domain.Model.OrderAggregate.Slot;
import com.arqsoft.server.Domain.Model.UserAggregate.User;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static Order DtoToDomainEntity(RequestOrderDTO requestOrderDTO, User user, SandwichOrder sandwichOrder) throws IllegalAccessException {
        return new Order(
                StatusMapper.stringToStatus(requestOrderDTO.getStatus()),
                user,
                new Slot(requestOrderDTO.getBeginningHour(),requestOrderDTO.getEndingHour()),
                sandwichOrder
        );

    }

    public static ResponseOrderDTO DomainEntityToDto (Order order){
        return new ResponseOrderDTO(
                order.getOrderId().getId(),
                StatusMapper.statusToString(order.getStatus()),
                UserMapper.DomainEntityToResponseDto(order.getStudent()),
                new ResponseSlotDTO(order.getSlot().getBeginningHour(),order.getSlot().getEndingDate()),
                SandwichOrderMapper.EntityMapToList(order.getSandwichOrder().getSandwichOrder())
        );
    }


    public static List<ResponseOrderDTO> DomainEntitiesToDtoList(List<Order> orders) {

        List<ResponseOrderDTO> responseOrderDTOS = new ArrayList<>();

        orders.forEach(order -> {
            responseOrderDTOS.add(DomainEntityToDto(order));
        });

        return responseOrderDTOS;
    }
}
