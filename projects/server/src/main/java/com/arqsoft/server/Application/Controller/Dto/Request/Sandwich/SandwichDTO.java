package com.arqsoft.server.Application.Controller.Dto.Request.Sandwich;

import java.util.List;

public class SandwichDTO {
    private String name;
    private String description;
    private int quantity;
    private String type;
    private List<RequestCommentDTO> commentList;

    public SandwichDTO(String name, String description, int quantity, String type, List<RequestCommentDTO> commentList) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
        this.commentList = commentList;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public List<RequestCommentDTO> getCommentList() {
        return commentList;
    }
}
