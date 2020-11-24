package com.arqsoft.server.Application.Controller.Dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class RequestDayScheduleDTO {

    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT")
    private Date beginningHour;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT")
    private Date endingHour;

    private int lastSlotTime;

    private int slotTime;

    public RequestDayScheduleDTO(Date beginningHour, Date endingHour,int lastSlotTime, int slotTime) {
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
        this.lastSlotTime = lastSlotTime;
        this.slotTime = slotTime;
    }

    public Date getBeginningHour() {
        return beginningHour;
    }

    public Date getEndingHour() {
        return endingHour;
    }

    public int getLastSlotTime() {
        return lastSlotTime;
    }

    public int getSlotTime() {
        return slotTime;
    }
}
