package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class BeginningHourJpa {

    @Column(name ="begginingHour")
    private Date beginningHour;

    public BeginningHourJpa(Date beginningHour) {
        this.beginningHour = beginningHour;
    }

    protected BeginningHourJpa() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeginningHourJpa that = (BeginningHourJpa) o;
        return beginningHour.equals(that.beginningHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginningHour);
    }

    public Date getBeginningHour() {
        return beginningHour;
    }
}
