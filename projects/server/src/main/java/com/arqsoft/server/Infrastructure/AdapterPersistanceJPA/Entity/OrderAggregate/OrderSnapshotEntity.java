package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate;

import com.arqsoft.server.Domain.Snapshot.UserSnapshot;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.ValueObject.Slot;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserSnapshotEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="orderSnapshot")
public class OrderSnapshotEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Long orderId;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name="userId",nullable=false)
    private UserSnapshotEntity userSnapshot;

    @Column
    @Embedded
    private Slot slot;

    //@ElementCollection
    //private Map<SandwichSnapshot, Integer> sandwichOrder;

    public OrderSnapshotEntity(Long orderId, String status, UserSnapshotEntity userSnapshot, Slot slot) {
        this.orderId = orderId;
        this.status = status;
        this.userSnapshot = userSnapshot;
        this.slot = slot;
       // this.sandwichOrder = sandwichOrder;
    }

    public OrderSnapshotEntity() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserSnapshotEntity getUserSnapshot() {
        return userSnapshot;
    }

    public void setUserSnapshot(UserSnapshotEntity userSnapshot) {
        this.userSnapshot = userSnapshot;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

//    public Map<SandwichEntity, Integer> getSandwichOrder() {
//        return sandwichOrder;
//    }
//
//    public void setSandwichOrder(Map<SandwichEntity, Integer> sandwichOrder) {
//        this.sandwichOrder = sandwichOrder;
//    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
