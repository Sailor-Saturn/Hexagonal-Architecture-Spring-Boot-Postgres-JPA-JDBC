package com.arqsoft.server.Application.Controller.Port;

import com.arqsoft.server.Application.Controller.Dto.Request.Sandwich.RequestSandwichDTO;
import com.arqsoft.server.Application.Controller.Dto.Sandwich.SandwichDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface SandwichControllerPort {

    ResponseEntity<SandwichDTO> createSandwich(@RequestBody RequestSandwichDTO requestSandwichDTO);

}
