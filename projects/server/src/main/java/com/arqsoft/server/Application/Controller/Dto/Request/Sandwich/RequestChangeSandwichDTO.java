package com.arqsoft.server.Application.Controller.Dto.Request.Sandwich;

public class RequestChangeSandwichDTO {

    private Integer quantity;
    private String description;
    private String type;
    private String name;

    protected RequestChangeSandwichDTO() {}

    public RequestChangeSandwichDTO(Integer quantity) {
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
