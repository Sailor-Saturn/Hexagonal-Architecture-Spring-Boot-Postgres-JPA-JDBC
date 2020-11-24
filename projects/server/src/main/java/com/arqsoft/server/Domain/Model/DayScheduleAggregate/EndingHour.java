package com.arqsoft.server.Domain.Model.DayScheduleAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Date;
import java.util.Objects;

public class EndingHour implements ValueObject {

    private Date endingHour;

    public EndingHour(Date endingHour) {
        Validate.isInstanceOf(Date.class, endingHour, "Ending hour must be instance of Date");
        this.endingHour = endingHour;
    }

    public Date getEndingHour() {
        return endingHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndingHour that = (EndingHour) o;
        return endingHour.equals(that.endingHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endingHour);
    }
}
