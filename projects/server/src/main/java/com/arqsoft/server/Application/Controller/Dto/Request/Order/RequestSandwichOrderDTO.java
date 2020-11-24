package com.arqsoft.server.Application.Controller.Dto.Request.Order;


import javax.validation.constraints.NotNull;

public class RequestSandwichOrderDTO {
    @NotNull
    Long sandwichId;

    @NotNull
    int quantity;

    public RequestSandwichOrderDTO(@NotNull Long sandwichId, @NotNull int quantity) {
        this.sandwichId = sandwichId;
        this.quantity = quantity;
    }

    public Long getSandwichId() {
        return sandwichId;
    }

    public int getQuantity() {
        return quantity;
    }
}
