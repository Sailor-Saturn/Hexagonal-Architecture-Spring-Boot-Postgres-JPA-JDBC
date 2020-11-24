package com.arqsoft.server.Application.Controller.Dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class RequestDaysOrdersDTO {

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT")
    private Date orderDate;

    @NotNull
    private Long dayScheduleId;

    @NotNull
    private List<Long> orders;

    public RequestDaysOrdersDTO(Date orderDate, @NotNull Long dayScheduleId, @NotNull List<Long> orders) {
        this.orderDate = orderDate;
        this.dayScheduleId = dayScheduleId;
        this.orders = orders;
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
