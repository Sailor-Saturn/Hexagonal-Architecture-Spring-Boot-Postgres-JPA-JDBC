package com.arqsoft.server.Application.Controller.Adapter;

import com.arqsoft.server.Application.Controller.Dto.DaysOrdersDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.RequestDaysOrdersDTO;
import com.arqsoft.server.Application.Controller.Mapper.DaysOrdersMapper;
import com.arqsoft.server.Application.Controller.Port.DaysOrdersControllerPort;
import com.arqsoft.server.Domain.Model.DayScheduleAggregate.DaySchedule;
import com.arqsoft.server.Domain.Model.DeliveryScheduleAggregate.DaysOrders;
import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Service.Port.DayScheduleService;
import com.arqsoft.server.Service.Port.DaysOrdersService;
import com.arqsoft.server.Service.Port.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/dayOrders")
public class DaysOrdersControllerAdapter implements DaysOrdersControllerPort {

    @Autowired
    DaysOrdersService daysOrdersService;

    @Autowired
    OrderService orderService;

    @Autowired
    DayScheduleService dayScheduleService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DaysOrdersDTO> createDaysOrders(RequestDaysOrdersDTO reqDaysOrdersDto) {

        List<Order> ordersList = orderService.getOrdersListById(reqDaysOrdersDto.getOrders());
        DaySchedule schedule = dayScheduleService.getDayScheduleById(reqDaysOrdersDto.getDayScheduleId());
        DaysOrders daysOrders = DaysOrdersMapper.RequestDtoToDomainEntity(reqDaysOrdersDto, ordersList, schedule);

        DaysOrders newOrder = null;

        try{
            newOrder = daysOrdersService.createDaysOrders(daysOrders);
        }catch (Exception e) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(
                DaysOrdersMapper.DomainEntityToDto(newOrder));
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<DaysOrdersDTO> updateDaysOrders(DaysOrdersDTO daysOrdersDto) {

        List<Order> ordersList = orderService.getOrdersListById(daysOrdersDto.getOrders());
        DaySchedule schedule = dayScheduleService.getDayScheduleById(daysOrdersDto.getDayScheduleId());

        DaysOrders orders = DaysOrdersMapper.DtoToDomainEntity(daysOrdersDto, ordersList, schedule);
        DaysOrders updatedOrders = null;

        try{
            updatedOrders = daysOrdersService.updateDaysOrders(orders);
        }catch (Exception e) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(
                DaysOrdersMapper.DomainEntityToDto(updatedOrders));
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DaysOrdersDTO>> getDaysOrders() {

        List<DaysOrders> daysOrdersList = daysOrdersService.getAllDaysOrders();
        return ResponseEntity.ok().body(
                DaysOrdersMapper.DomainEntitiesToDTO(daysOrdersList));
    }

    @Override
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<DaysOrdersDTO> getDaysOrdersById(@Valid long id) {
        try {
           DaysOrders daysOrders = daysOrdersService.getDaysOrdersById(id);

            return ResponseEntity.ok().body(
                    DaysOrdersMapper.DomainEntityToDto(daysOrders));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDaysOrders(@Valid long id) {
        try{

            boolean response = daysOrdersService.removeDaysOrders(id);

            if(response){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body("Successfully deleted the DaysOrders.");
        } catch (IllegalArgumentException | NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
