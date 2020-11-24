package com.arqsoft.server.Application.Controller.Port;

import com.arqsoft.server.Application.Controller.Dto.Request.Order.RequestChangeOrderDTO;
import com.arqsoft.server.Application.Controller.Dto.Response.Order.ResponseOrderDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.Order.RequestOrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderControllerPort {
    public ResponseEntity<ResponseOrderDTO> createOrder(@RequestBody RequestOrderDTO requestOrderDTO) throws IllegalAccessException;

    public ResponseEntity<ResponseOrderDTO> updateOrder(@RequestBody RequestChangeOrderDTO requestChangeOrderDTO, @PathVariable("id") long id);

    public ResponseEntity<ResponseOrderDTO> getOrderById(@PathVariable("id") long id);

    public ResponseEntity<List<ResponseOrderDTO>> getOrders();


}
