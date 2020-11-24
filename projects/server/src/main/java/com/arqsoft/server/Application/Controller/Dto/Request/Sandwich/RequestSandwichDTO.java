package com.arqsoft.server.Application.Controller.Dto.Request.Sandwich;

public class RequestSandwichDTO {
    private String name;
    private String description;
    private String type;

    public RequestSandwichDTO(long id, String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
