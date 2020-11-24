package com.arqsoft.server.Application.Controller.Mapper;

import com.arqsoft.server.Application.Controller.Dto.DayScheduleDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.RequestDayScheduleDTO;
import com.arqsoft.server.Domain.Model.DayScheduleAggregate.*;

import java.util.ArrayList;
import java.util.List;

public class DayScheduleMapper {

    public static DaySchedule RequestDtoToDomainEntity(RequestDayScheduleDTO reqDayScheduleDto) {

        return new DaySchedule(
                new BeginningHour(reqDayScheduleDto.getBeginningHour()),
                new EndingHour(reqDayScheduleDto.getEndingHour()),
                new SlotTime(reqDayScheduleDto.getSlotTime()),
                new LastSlotTime(reqDayScheduleDto.getLastSlotTime())
        );
    }

    public static DaySchedule DtoToDomainEntity(DayScheduleDTO dayScheduleDto) {

        return new DaySchedule(
                new DayScheduleId(dayScheduleDto.getId()),
                new BeginningHour(dayScheduleDto.getBeginningHour()),
                new LastSlotTime(dayScheduleDto.getLastSlotTime()),
                new EndingHour(dayScheduleDto.getEndingHour()),
                new SlotTime(dayScheduleDto.getSlotTime())
        );
    }

    public static DayScheduleDTO DomainEntityToDto (DaySchedule daySchedule){
        return new DayScheduleDTO(
                daySchedule.getBeginningHour().getBeginningHour(),
                daySchedule.getEndingHour().getEndingHour(),
                daySchedule.getSlotTime().getSlotTime(),
                daySchedule.getLastSlotTime().getLastSlotTime(),
                daySchedule.getDayScheduleId().getId()
        );
    }

    public static List<DayScheduleDTO> DomainEntitiesToDTO(List<DaySchedule> dayScheduleList){
        List<DayScheduleDTO> dayScheduleDTOList = new ArrayList<>();

        dayScheduleList.forEach( daySchedule -> {
            dayScheduleDTOList.add(DomainEntityToDto(daySchedule));
                });

        return dayScheduleDTOList;
    }
}
