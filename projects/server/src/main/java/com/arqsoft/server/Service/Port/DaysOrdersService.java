package com.arqsoft.server.Service.Port;

import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DaysOrders;

import java.util.List;
import java.util.Optional;

public interface DaysOrdersService {

    DaysOrders createDaysOrders(DaysOrders orders);

    DaysOrders updateDaysOrders(DaysOrders updatedOrders);

    boolean removeDaysOrders(Long id);

    List<DaysOrders> getAllDaysOrders();

    DaysOrders getDaysOrdersById(Long id);
}
