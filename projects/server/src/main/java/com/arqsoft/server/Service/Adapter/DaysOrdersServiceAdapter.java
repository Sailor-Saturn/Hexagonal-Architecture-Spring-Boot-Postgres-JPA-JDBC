package com.arqsoft.server.Service.Adapter;

import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DaysOrders;
import com.arqsoft.server.Domain.Port.DaysOrdersPersistencePort;
import com.arqsoft.server.Service.Port.DaysOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DaysOrdersServiceAdapter implements DaysOrdersService {

    @Autowired
    DaysOrdersPersistencePort daysOrdersPersistence;

    @Override
    public DaysOrders createDaysOrders(DaysOrders orders) {
        return daysOrdersPersistence.createDayOrder(orders);
    }

    @Override
    public DaysOrders updateDaysOrders(DaysOrders updatedOrders) {
        return daysOrdersPersistence.updateDaysOrders(updatedOrders);
    }

    @Override
    public boolean removeDaysOrders(Long id) {
        return daysOrdersPersistence.removeDaysOrders(id);
    }

    @Override
    public List<DaysOrders> getAllDaysOrders() {
        return daysOrdersPersistence.getAllDaysOrders();
    }

    @Override
    public DaysOrders getDaysOrdersById(Long id) {
        return daysOrdersPersistence.getDaysOrdersById(id);
    }
}
