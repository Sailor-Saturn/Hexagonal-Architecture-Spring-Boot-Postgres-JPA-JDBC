package com.arqsoft.server.Application.Controller.Dto.Response.Order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ResponseSlotDTO {
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT")
    private Date beginningHour;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT")
    private Date endingDate;

    public ResponseSlotDTO(Date beginningHour, Date endingDate) {
        this.beginningHour = beginningHour;
        this.endingDate = endingDate;
    }

    public Date getBeginningHour() {
        return beginningHour;
    }

    public Date getEndingDate() {
        return endingDate;
    }
}
