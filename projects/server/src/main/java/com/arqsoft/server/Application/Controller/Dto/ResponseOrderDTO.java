package com.arqsoft.server.Application.Controller.Dto.Response;

import com.arqsoft.server.Domain.Model.OrderAggregate.Quantity;
import com.arqsoft.server.Domain.Model.OrderAggregate.SandwichOrder;
import com.arqsoft.server.Domain.Model.UserAggregate.User;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class ResponseOrderDTO {
    @NotNull
    private String status;

    @NotNull
    private User user;

    @NotNull
    private int slot;

    @NotNull
    private SandwichOrder sandwichOrder;

    public ResponseOrderDTO(@NotNull String status, @NotNull User user, @NotNull int slot, @NotNull SandwichOrder sandwichOrderId) {
        this.status = status;
        this.user = user;
        this.slot = slot;
        this.sandwichOrder = sandwichOrder;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public int getSlot() {
        return slot;
    }

    public SandwichOrder getSandwichOrder() {
        return sandwichOrder;
    }
}
