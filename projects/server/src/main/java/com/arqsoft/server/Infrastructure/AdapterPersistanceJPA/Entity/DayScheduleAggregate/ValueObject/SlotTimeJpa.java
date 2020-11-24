package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class SlotTimeJpa {

    @Column(name ="slotTime")
    private int slotTime;

    public SlotTimeJpa(int slotTime) {
        this.slotTime = slotTime;
    }

    protected SlotTimeJpa() {}

    public int getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(int slotTime) {
        this.slotTime = slotTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotTimeJpa that = (SlotTimeJpa) o;
        return slotTime == that.slotTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotTime);
    }
}
