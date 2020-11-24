package com.arqsoft.server.Application.Controller.Dto.Response.Order;

import com.arqsoft.server.Application.Controller.Dto.Response.ResponseUserDTO;

import java.util.List;

public class ResponseOrderDTO {
    private Long id;
    private String status;
    private ResponseUserDTO user;
    private ResponseSlotDTO responseSlotDTO;
    private List<ResponseSandwichOrderDTO> responseSandwichOrderDTO;

    public ResponseOrderDTO(Long id, String status, ResponseUserDTO user, ResponseSlotDTO responseSlotDTO, List<ResponseSandwichOrderDTO> responseSandwichOrderDTO) {
        this.id = id;
        this.status = status;
        this.user = user;
        this.responseSlotDTO = responseSlotDTO;
        this.responseSandwichOrderDTO = responseSandwichOrderDTO;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public ResponseUserDTO getUser() {
        return user;
    }

    public ResponseSlotDTO getSlotDTO() {
        return responseSlotDTO;
    }

    public List<ResponseSandwichOrderDTO> getSandwichOrderDTO() {
        return responseSandwichOrderDTO;
    }
}
