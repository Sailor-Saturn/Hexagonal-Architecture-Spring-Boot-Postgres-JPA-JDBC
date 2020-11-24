package com.arqsoft.server.Application.Controller.Dto.Response.Order;

import javax.validation.constraints.NotNull;

public class ResponseSandwichOrderDTO {
    @NotNull
    Long sandwichId;

    @NotNull
    int quantity;

    public ResponseSandwichOrderDTO(@NotNull Long sandwichId, @NotNull int quantity) {
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
