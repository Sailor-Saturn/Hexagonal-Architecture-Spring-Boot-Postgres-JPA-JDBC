package com.arqsoft.server.Application.Controller.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class DaysOrdersDTO {

    @NotNull
    private Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT")
    private Date orderDate;

    @NotNull
    private Long dayScheduleId;

    @NotNull
    private List<Long> orders;

    public DaysOrdersDTO(@NotNull Long id, Date orderDate, @NotNull Long dayScheduleId, @NotNull List<Long> orders) {
        this.id = id;
        this.orderDate = orderDate;
        this.dayScheduleId = dayScheduleId;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Long getDayScheduleId() {
        return dayScheduleId;
    }

    public List<Long> getOrders() {
        return orders;
    }
}
