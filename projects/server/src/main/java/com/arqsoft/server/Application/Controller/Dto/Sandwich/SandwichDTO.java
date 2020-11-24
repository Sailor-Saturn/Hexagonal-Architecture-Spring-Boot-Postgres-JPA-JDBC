package com.arqsoft.server.Application.Controller.Dto.Sandwich;

import java.util.List;

public class SandwichDTO {
    private long id;
    private String name;
    private String description;
    private int quantity;
    private String type;
    private List<CommentDTO> comments;

    public SandwichDTO(long id, String name, String description, int quantity, String type, List<CommentDTO> comments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
        this.comments = comments;
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

    public long getId() {
        return id;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }
}
