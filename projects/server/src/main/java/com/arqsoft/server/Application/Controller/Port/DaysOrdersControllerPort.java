package com.arqsoft.server.Application.Controller.Port;

import com.arqsoft.server.Application.Controller.Dto.DaysOrdersDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.RequestDaysOrdersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface DaysOrdersControllerPort {

    ResponseEntity<DaysOrdersDTO> createDaysOrders(@RequestBody RequestDaysOrdersDTO reqDaysOrdersDto);

    ResponseEntity<DaysOrdersDTO> updateDaysOrders(@RequestBody DaysOrdersDTO daysOrdersDto);

    ResponseEntity<List<DaysOrdersDTO>> getDaysOrders();

    ResponseEntity<DaysOrdersDTO> getDaysOrdersById(@Valid @PathVariable("id") long id);

    ResponseEntity<?> deleteDaysOrders(@Valid @PathVariable("id") long id);
}
