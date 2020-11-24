package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate;

import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.DayScheduleEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate.ValueObject.OrderDate;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.OrderEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="DaysOrders")
public class DaysOrdersEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected DaysOrdersEntity() { }

    public DaysOrdersEntity(OrderDate orderDate, DayScheduleEntity daySchedule, List<OrderEntity> ordersList) {
        this.orderDate = orderDate;
        this.daySchedule = daySchedule;
        this.ordersList = ordersList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    @Embedded
    private OrderDate orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dayScheduleId")
    private DayScheduleEntity daySchedule;

    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderEntity> ordersList;

    public Long getId() {
        return Id;
    }

    public OrderDate getOrderDate() {
        return orderDate;
    }

    public DayScheduleEntity getDaySchedule() {
        return daySchedule;
    }

    public List<OrderEntity> getOrdersList() {
        return ordersList;
    }

    public void setOrderDate(OrderDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setDaySchedule(DayScheduleEntity daySchedule) {
        this.daySchedule = daySchedule;
    }

   public void setOrdersList(List<OrderEntity> ordersList) {
        this.ordersList = ordersList;
    }
}
