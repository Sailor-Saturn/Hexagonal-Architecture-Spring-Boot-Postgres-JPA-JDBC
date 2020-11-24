package com.arqsoft.server.Application.Controller.Mapper;

import com.arqsoft.server.Application.Controller.Dto.DaysOrdersDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.RequestDaysOrdersDTO;
import com.arqsoft.server.Domain.Model.DayScheduleAggregate.DaySchedule;
import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DatePrimitive;
import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DaysOrders;
import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DaysOrdersId;
import com.arqsoft.server.Domain.Model.OrderAggregate.Order;

import java.util.ArrayList;
import java.util.List;

public class DaysOrdersMapper {

    public static DaysOrders RequestDtoToDomainEntity(RequestDaysOrdersDTO reqDaysOrdersDto, List<Order> ordersList, DaySchedule schedule) {

        return new DaysOrders(
                new DatePrimitive(reqDaysOrdersDto.getOrderDate()),
                        ordersList,
                        schedule);
    }

    public static DaysOrders DtoToDomainEntity(DaysOrdersDTO daysOrdersDto, List<Order> ordersList, DaySchedule schedule) {

        return new DaysOrders(
                new DaysOrdersId(daysOrdersDto.getId()),
                new DatePrimitive(daysOrdersDto.getOrderDate()),
                ordersList,
                schedule
        );
    }

    public static DaysOrdersDTO DomainEntityToDto (DaysOrders daysOrders){

        return new DaysOrdersDTO(
                daysOrders.getId().getId(),
                daysOrders.getDate().getDate(),
                daysOrders.getDaySchedule().getDayScheduleId().getId(),
                getOrdersIdList(daysOrders.getOrderList())
        );
    }

    public static List<DaysOrdersDTO> DomainEntitiesToDTO(List<DaysOrders> daysOrdersList){
        List<DaysOrdersDTO> ordersDTOList = new ArrayList<>();

        daysOrdersList.forEach( orders -> {
            ordersDTOList.add(DomainEntityToDto(orders));
        });
        return ordersDTOList;
    }

    private static List<Long> getOrdersIdList (List<Order> ordersList){
        List<Long> ordersIdList = new ArrayList<>();

        ordersList.forEach( order -> {
            ordersIdList.add(order.getOrderId().getId());
        });

        return ordersIdList;
    }
}
