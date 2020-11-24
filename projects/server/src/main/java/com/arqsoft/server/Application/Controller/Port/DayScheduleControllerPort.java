package com.arqsoft.server.Application.Controller.Port;

import com.arqsoft.server.Application.Controller.Dto.Request.RequestDayScheduleDTO;
import com.arqsoft.server.Application.Controller.Dto.DayScheduleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


public interface DayScheduleControllerPort {

    ResponseEntity<DayScheduleDTO> defineDaySchedule(@RequestBody RequestDayScheduleDTO scheduleDTO);

    ResponseEntity<DayScheduleDTO> updateDaySchedule(@RequestBody DayScheduleDTO scheduleDTO);

    ResponseEntity<List<DayScheduleDTO>> getDaySchedules();

    ResponseEntity<DayScheduleDTO> getDayScheduleById(@Valid @PathVariable("id") long id);

    ResponseEntity<?> deleteDaySchedule(@Valid @PathVariable("id") long id);
}
