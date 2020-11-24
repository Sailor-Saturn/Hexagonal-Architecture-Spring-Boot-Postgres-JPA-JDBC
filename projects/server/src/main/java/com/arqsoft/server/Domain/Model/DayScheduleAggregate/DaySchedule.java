package com.arqsoft.server.Domain.Model.DayScheduleAggregate;

import com.arqsoft.server.Domain.Interface.Entity;

public class DaySchedule implements Entity {

    private DayScheduleId dayScheduleId;
    private BeginningHour beginningHour;
    private LastSlotTime lastSlotTime;
    private EndingHour endingHour;
    private SlotTime slotTime;

    public DaySchedule(BeginningHour beginningHour, EndingHour endingHour, SlotTime slotTime, LastSlotTime lastSlotTime) {
        this.beginningHour = beginningHour;
        this.endingHour = endingHour;
        this.slotTime = slotTime;
        this.lastSlotTime = lastSlotTime;
    }

    public DaySchedule(DayScheduleId dayScheduleId, BeginningHour beginningHour, LastSlotTime lastSlotTime, EndingHour endingHour, SlotTime slotTime) {
        this.dayScheduleId = dayScheduleId;
        this.beginningHour = beginningHour;
        this.lastSlotTime = lastSlotTime;
        this.endingHour = endingHour;
        this.slotTime = slotTime;
    }

    public BeginningHour getBeginningHour() {
        return beginningHour;
    }

    public LastSlotTime getLastSlotTime() {
        return lastSlotTime;
    }

    public EndingHour getEndingHour() {
        return endingHour;
    }

    public SlotTime getSlotTime() {
        return slotTime;
    }

    public DayScheduleId getDayScheduleId() {
        return dayScheduleId;
    }

}
