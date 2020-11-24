package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.DayScheduleAggregate.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class EndingHourJpa {

    @Column(name ="endingHour")
    private Date endingHour;

    public EndingHourJpa(Date endingHour) {
        this.endingHour = endingHour;
    }

    protected EndingHourJpa() { }

    public Date getEndingHour() {
        return endingHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndingHourJpa that = (EndingHourJpa) o;
        return Objects.equals(endingHour, that.endingHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endingHour);
    }
}
