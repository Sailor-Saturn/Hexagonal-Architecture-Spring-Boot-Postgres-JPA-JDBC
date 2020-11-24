package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.DayScheduleEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DeliveryScheduleAggregate.ValueObject.OrderDate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="daysOrdersSnapshot")
public class DaysOrdersSnapshotEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected DaysOrdersSnapshotEntity() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Long daysOrdersId;

    @Column
    @Embedded
    private OrderDate orderDate;

    public Long getId() {
        return Id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dayScheduleId")
    private DayScheduleEntity daySchedule;

    public Long getDaysOrdersId() {
        return daysOrdersId;
    }

    public OrderDate getOrderDate() {
        return orderDate;
    }

    public DayScheduleEntity getDaySchedule() {
        return daySchedule;
    }

    public void setDaySchedule(DayScheduleEntity daySchedule) {
        this.daySchedule = daySchedule;
    }

    public void setOrderDate(OrderDate orderDate) {
        this.orderDate = orderDate;
    }
}
