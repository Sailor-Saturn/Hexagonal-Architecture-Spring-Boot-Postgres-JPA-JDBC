package com.arqsoft.server.Domain.Model.DayScheduleAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Date;
import java.util.Objects;

public class BeginningHour implements ValueObject {
    private Date beginningHour;

    public BeginningHour(Date beginningHour) {
        Validate.isInstanceOf(Date.class, beginningHour, "Beginning Hour must be instance of Date");
        this.beginningHour = beginningHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeginningHour that = (BeginningHour) o;
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
