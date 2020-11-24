package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.ValueObject.Slot;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.SandwichEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name="OrderSandwich")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name="userId",nullable=false)
    private UserEntity userEntity;

    @Column
    @Embedded
    private Slot slot;

    @ElementCollection
    private Map<SandwichEntity, Integer> sandwichOrder;

    public OrderEntity(String status, UserEntity userEntity, Slot slot, Map<SandwichEntity, Integer> sandwichOrder) {
        this.status = status;
        this.userEntity = userEntity;
        this.slot = slot;
        this.sandwichOrder = sandwichOrder;
    }

    public OrderEntity(Long id, String status, UserEntity userEntity, Slot slot, Map<SandwichEntity, Integer> sandwichOrder) {
        this.Id = id;
        this.status = status;
        this.userEntity = userEntity;
        this.slot = slot;
        this.sandwichOrder = sandwichOrder;
    }

    public OrderEntity() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return Id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Map<SandwichEntity, Integer> getSandwichOrder() {
        return sandwichOrder;
    }

    public void setSandwichOrder(Map<SandwichEntity, Integer> sandwichOrder) {
        this.sandwichOrder = sandwichOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderEntity)) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(Id, that.Id) &&
                Objects.equals(status, that.status) &&
                Objects.equals(userEntity, that.userEntity) &&
                Objects.equals(slot, that.slot) &&
                Objects.equals(sandwichOrder, that.sandwichOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, status, userEntity, slot, sandwichOrder);
    }
}
