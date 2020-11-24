package com.arqsoft.server.Domain.Model.DayScheduleAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class LastSlotTime implements ValueObject {
    private int lastSlotTime;

    public LastSlotTime(int lastSlotTime) {
        Validate.isTrue(lastSlotTime > 0, "Last slot time must be greater than zero. Received: %d", lastSlotTime);
        this.lastSlotTime = lastSlotTime;
    }

    public int getLastSlotTime() {
        return lastSlotTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastSlotTime that = (LastSlotTime) o;
        return lastSlotTime == that.lastSlotTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastSlotTime);
    }

    @Override
    public String toString() {
        return  String.valueOf(lastSlotTime);
    }
}
