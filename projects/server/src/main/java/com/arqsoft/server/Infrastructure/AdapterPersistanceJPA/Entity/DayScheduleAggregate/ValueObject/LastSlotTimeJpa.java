package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class LastSlotTimeJpa {

    @Column(name ="lastSlotTime")
    private int lastSlotTime;

    public LastSlotTimeJpa(int lastSlotTime) {
        this.lastSlotTime = lastSlotTime;
    }

    protected LastSlotTimeJpa() { }

    public int getLastSlotTime() {
        return lastSlotTime;
    }

    public void setLastSlotTime(int lastSlotTime) {
        this.lastSlotTime = lastSlotTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastSlotTimeJpa that = (LastSlotTimeJpa) o;
        return lastSlotTime == that.lastSlotTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastSlotTime);
    }
}
