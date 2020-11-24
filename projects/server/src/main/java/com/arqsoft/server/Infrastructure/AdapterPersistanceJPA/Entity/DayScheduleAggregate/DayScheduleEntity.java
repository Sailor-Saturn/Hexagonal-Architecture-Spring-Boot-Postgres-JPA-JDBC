package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.BeginningHourJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.EndingHourJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.LastSlotTimeJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.SlotTimeJpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="DaySchedule")
public class DayScheduleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected DayScheduleEntity() {}

    public DayScheduleEntity(BeginningHourJpa beginningHour, EndingHourJpa endingHour, LastSlotTimeJpa lastSlotTime, SlotTimeJpa slotTime) {
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
        this.lastSlotTime = lastSlotTime;
        this.slotTime = slotTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    @Embedded
    private BeginningHourJpa beginningHour;

    @Column
    @Embedded
    private EndingHourJpa endingHour;

    @Column
    @Embedded
    private LastSlotTimeJpa lastSlotTime;

    @Column
    @Embedded
    private SlotTimeJpa slotTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return Id;
    }

    public BeginningHourJpa getBeginningHour() {
        return beginningHour;
    }

    public EndingHourJpa getEndingHour() {
        return endingHour;
    }

    public LastSlotTimeJpa getLastSlotTime() {
        return lastSlotTime;
    }

    public SlotTimeJpa getSlotTime() {
        return slotTime;
    }

    public void setBeginningHour(BeginningHourJpa beginningHour) {
        this.beginningHour = beginningHour;
    }

    public void setEndingHour(EndingHourJpa endingHour) {
        this.endingHour = endingHour;
    }

    public void setLastSlotTime(LastSlotTimeJpa lastSlotTime) {
        this.lastSlotTime = lastSlotTime;
    }

    public void setSlotTime(SlotTimeJpa slotTime) {
        this.slotTime = slotTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayScheduleEntity that = (DayScheduleEntity) o;
        return Objects.equals(Id, that.Id) &&
                Objects.equals(beginningHour, that.beginningHour) &&
                Objects.equals(endingHour, that.endingHour) &&
                Objects.equals(lastSlotTime, that.lastSlotTime) &&
                Objects.equals(slotTime, that.slotTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, beginningHour, endingHour, lastSlotTime, slotTime);
    }
}
