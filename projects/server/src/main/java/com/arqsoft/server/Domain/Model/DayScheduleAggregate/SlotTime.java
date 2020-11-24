package com.arqsoft.server.Domain.Model.DayScheduleAggregate;

import com.arqsoft.server.Domain.Interface.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class SlotTime implements ValueObject {

    private int slotTime;

    public SlotTime(int slotTime) {
        Validate.isTrue(slotTime > 0, "Last slot time must be greater than zero. Received: %d", slotTime);
        this.slotTime = slotTime;
    }

    public int getSlotTime() {
        return slotTime;
    }

    @Override
    public String toString() {
        return  String.valueOf(slotTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotTime slotTime1 = (SlotTime) o;
        return slotTime == slotTime1.slotTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotTime);
    }
}
