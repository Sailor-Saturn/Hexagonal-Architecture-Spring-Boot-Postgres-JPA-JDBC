package com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.Sandwich;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("sandwich")
public class SandwichJDBC {

    @Id
    private Long id;

    private String name;

    private String description;

    private int quantity;

    private String type;

    protected SandwichJDBC() {}

    public SandwichJDBC(Long id, String name, String description, int quantity, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
    }

    public SandwichJDBC(String name, String description, int quantity, String type) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
    }

    public Long getId() {
        return id;
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
}
