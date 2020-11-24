package com.arqsoft.server.Application.Controller.Adapter;

import com.arqsoft.server.Application.Controller.Dto.DayScheduleDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.RequestDayScheduleDTO;
import com.arqsoft.server.Application.Controller.Mapper.DayScheduleMapper;
import com.arqsoft.server.Application.Controller.Port.DayScheduleControllerPort;
import com.arqsoft.server.Domain.Model.DayScheduleAggregate.DaySchedule;
import com.arqsoft.server.Service.Port.DayScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class DayScheduleControllerAdapter implements DayScheduleControllerPort {

    @Autowired
    DayScheduleService dayScheduleService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DayScheduleDTO> defineDaySchedule(RequestDayScheduleDTO reqScheduleDTO) {

        DaySchedule daySchedule = DayScheduleMapper.RequestDtoToDomainEntity(reqScheduleDTO);

        DaySchedule newDaySchedule = null;

        try{
            newDaySchedule = dayScheduleService.defineDaySchedule(daySchedule);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(
                DayScheduleMapper.DomainEntityToDto(newDaySchedule));

    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<DayScheduleDTO> updateDaySchedule(DayScheduleDTO scheduleDTO) {

        DaySchedule daySchedule = DayScheduleMapper.DtoToDomainEntity(scheduleDTO);

        DaySchedule updatedDaySchedule = null;

        try{
            updatedDaySchedule = dayScheduleService.updateDaySchedule(daySchedule);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(
                DayScheduleMapper.DomainEntityToDto(updatedDaySchedule));
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DayScheduleDTO>> getDaySchedules() {

        List<DaySchedule> dayScheduleList = dayScheduleService.getDaySchedules();

        return ResponseEntity.ok().body(
                DayScheduleMapper.DomainEntitiesToDTO(dayScheduleList));
    }

    @Override
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<DayScheduleDTO> getDayScheduleById(@PathVariable("id") long id) {
        try {
            DaySchedule daySchedule = dayScheduleService.getDayScheduleById(id);

            return ResponseEntity.ok().body(
                    DayScheduleMapper.DomainEntityToDto(daySchedule));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDaySchedule(@Valid long id) {
        try{

        boolean response = dayScheduleService.removeDaySchedule(id);

        if(response){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body("Successfully deleted the DaySchedule.");
        } catch (IllegalArgumentException | NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
