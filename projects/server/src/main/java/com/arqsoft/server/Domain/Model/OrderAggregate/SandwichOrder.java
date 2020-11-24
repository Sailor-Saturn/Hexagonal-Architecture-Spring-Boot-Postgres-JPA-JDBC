package com.arqsoft.server.Domain.Model.OrderAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;

import java.util.HashMap;
import java.util.Map;

public class SandwichOrder implements ValueObject {

    private Map<Sandwich,Quantity> sandwichOrder;

    public SandwichOrder(Map<Sandwich, Quantity> sandwichOrder) {
        this.sandwichOrder = sandwichOrder;
    }

    public SandwichOrder() {
        sandwichOrder = new HashMap<>();
    }

    public boolean hasSandwich(Sandwich sandwich) {
        return sandwichOrder.containsKey(sandwich);
    }

    public Map<Sandwich, Quantity> getSandwichOrder() {
        return sandwichOrder;
    }

    public void setSandwichOrder(Map<Sandwich, Quantity> sandwichOrder) {
        this.sandwichOrder = sandwichOrder;
    }

    public void addSandwichQuantity(Sandwich sandwich,Quantity quantity){
        sandwichOrder.put(sandwich,quantity);
    }
}
