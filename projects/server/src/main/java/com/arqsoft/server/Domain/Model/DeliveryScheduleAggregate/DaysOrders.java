package com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate;

import com.arqsoft.server.Domain.Model.DayScheduleAggregate.DaySchedule;
import com.arqsoft.server.Domain.Interface.Entity;
import com.arqsoft.server.Domain.Model.OrderAggregate.Order;

import java.util.List;

public class DaysOrders implements Entity {

    private DaysOrdersId Id;
    private DatePrimitive date;
    private List<Order> orderList;
    private DaySchedule daySchedule;

    public DaysOrders(DatePrimitive date, List<Order> orderList, DaySchedule daySchedule) {
        this.date = date;
        this.orderList = orderList;
        this.daySchedule = daySchedule;
    }

    public DaysOrders(DaysOrdersId id, DatePrimitive date, List<Order> orderList, DaySchedule daySchedule) {
        Id = id;
        this.date = date;
        this.orderList = orderList;
        this.daySchedule = daySchedule;
    }

    public DaysOrdersId getId() {
        return Id;
    }

    public void setId(DaysOrdersId id) {
        Id = id;
    }

    public DatePrimitive getDate() {
        return date;
    }

    public void setDate(DatePrimitive date) {
        this.date = date;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public DaySchedule getDaySchedule() {
        return daySchedule;
    }

    public void setDaySchedule(DaySchedule daySchedule) {
        this.daySchedule = daySchedule;
    }
}
