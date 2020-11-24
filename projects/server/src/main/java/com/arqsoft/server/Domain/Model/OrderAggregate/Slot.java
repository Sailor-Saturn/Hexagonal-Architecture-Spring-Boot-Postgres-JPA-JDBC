package com.arqsoft.server.Domain.Model.OrderAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Date;
import java.util.Objects;

public class Slot implements ValueObject {

    private Date beginningHour;
    private Date endingDate;

    public Slot(Date beginningHour, Date endingDate) {
        Validate.isInstanceOf(Date.class, beginningHour, "Begin date must be instance of Date class");
        Validate.isInstanceOf(Date.class, endingDate, "End date must be instance of Date class");

        this.beginningHour = beginningHour;
        this.endingDate = endingDate;
    }

    public Date getBeginningHour() {
        return beginningHour;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return beginningHour.equals(slot.beginningHour) &&
                endingDate.equals(slot.endingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginningHour, endingDate);
    }
}
