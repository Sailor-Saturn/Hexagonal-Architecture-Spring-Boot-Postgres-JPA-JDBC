package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.BeginningHourJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.EndingHourJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.LastSlotTimeJpa;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject.SlotTimeJpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="dayScheduleSnapshot")
public class DayScheduleSnapshotEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public DayScheduleSnapshotEntity(Long dayScheduleId, BeginningHourJpa beginningHour, EndingHourJpa endingHour, LastSlotTimeJpa lastSlotTime, SlotTimeJpa slotTime) {
        this.dayScheduleId = dayScheduleId;
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
        this.lastSlotTime = lastSlotTime;
        this.slotTime = slotTime;
    }

    protected DayScheduleSnapshotEntity() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Long dayScheduleId;

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

    public Long getDayScheduleId() {
        return dayScheduleId;
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
}
