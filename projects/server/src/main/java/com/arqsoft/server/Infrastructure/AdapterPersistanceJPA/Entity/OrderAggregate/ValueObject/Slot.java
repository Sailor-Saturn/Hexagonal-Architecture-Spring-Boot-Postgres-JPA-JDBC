package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.OrderAggregate.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class Slot {
    @Column(name="beginningHour")
    private Date beginningHour;

    @Column(name="endingHour")
    private Date endingHour;

    public Slot(Date beginningHour, Date endingHour) {
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
    }

    public Slot() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Slot)) return false;
        Slot slot = (Slot) o;
        return Objects.equals(beginningHour, slot.beginningHour) &&
                Objects.equals(endingHour, slot.endingHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginningHour, endingHour);
    }

    public Date getBeginningHour() {
        return beginningHour;
    }

    public Date getEndingHour() {
        return endingHour;
    }
}
