package com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Date;
import java.util.Objects;

public class DatePrimitive implements ValueObject {

    private Date date;

    public DatePrimitive(Date date) {
        Validate.isInstanceOf(Date.class, date, "Date must be instance of Date class");
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatePrimitive that = (DatePrimitive) o;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
