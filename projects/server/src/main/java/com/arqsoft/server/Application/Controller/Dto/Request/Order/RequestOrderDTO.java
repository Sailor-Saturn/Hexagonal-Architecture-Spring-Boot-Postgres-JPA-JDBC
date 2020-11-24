package com.arqsoft.server.Application.Controller.Dto.Request.Order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class RequestOrderDTO {

    @NotNull
    private String status;

    @NotNull
    private Long studentId;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT")
    private Date beginningHour;

    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm", timezone = "GMT")
    private Date endingHour;

    @NotNull
    private List<RequestSandwichOrderDTO> sandwichOrder;

    public RequestOrderDTO(@NotNull String status, @NotNull Long studentId, Date beginningHour, Date endingHour, @NotNull List<RequestSandwichOrderDTO> sandwichOrder) {
        this.status = status;
        this.studentId = studentId;
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
        this.sandwichOrder = sandwichOrder;
    }

    public String getStatus() {
        return status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Date getBeginningHour() {
        return beginningHour;
    }

    public Date getEndingHour() {
        return endingHour;
    }

    public List<RequestSandwichOrderDTO> getSandwichOrder() {
        return sandwichOrder;
    }
}
