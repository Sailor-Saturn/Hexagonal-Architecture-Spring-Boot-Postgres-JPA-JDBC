package com.arqsoft.server.Domain.Port;

import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DaysOrders;

import java.util.List;
import java.util.Optional;

public interface DaysOrdersPersistencePort {

    DaysOrders createDayOrder(DaysOrders daysOrders);

    DaysOrders updateDaysOrders(DaysOrders updatedOrders);

    boolean removeDaysOrders(Long id);

    List<DaysOrders> getAllDaysOrders();

    DaysOrders getDaysOrdersById(Long id);
}
