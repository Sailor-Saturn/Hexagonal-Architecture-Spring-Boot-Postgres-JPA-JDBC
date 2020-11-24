package com.arqsoft.server.Application.Controller.Dto.Request.Order;

public class RequestChangeOrderDTO {

    private String status;

    protected RequestChangeOrderDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
