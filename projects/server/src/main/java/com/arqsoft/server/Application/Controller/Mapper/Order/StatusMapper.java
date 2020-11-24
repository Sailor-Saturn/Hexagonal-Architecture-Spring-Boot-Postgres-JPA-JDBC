package com.arqsoft.server.Application.Controller.Mapper.Order;

import com.arqsoft.server.Domain.Model.Enum.Status;

public class StatusMapper {
    public static Status stringToStatus(String status){
        switch (status){
            case "PURCHASED":
                return Status.PURCHASED;
            case "READY_TO_PICK":
                return Status.READY_TO_PICK;
            case "DELIVERED":
                return Status.DELIVERED;
            case "NOT_PICKED_UP":
                return Status.NOT_PICKED_UP;
            case "PREPARING":
                return Status.PREPARING;
            default:
                return Status.ERROR;
        }
    }

    public static String statusToString (Status status){
        switch(status){
            case PURCHASED:
                return "PURCHASED";
            case READY_TO_PICK:
                return "READY_TO_PICK";
            case DELIVERED:
                return "DELIVERED";
            case NOT_PICKED_UP:
                return "NOT_PICKED_UP";
            case PREPARING:
                return "PREPARING";
            default:
                return "ERROR";
        }
    }
}
