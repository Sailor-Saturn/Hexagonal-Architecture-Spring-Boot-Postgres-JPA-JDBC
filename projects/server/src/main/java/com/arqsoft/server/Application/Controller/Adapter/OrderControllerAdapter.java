package com.arqsoft.server.Application.Controller.Adapter;

import com.arqsoft.server.Application.Controller.Dto.Request.Order.RequestChangeOrderDTO;
import com.arqsoft.server.Application.Controller.Dto.Response.Order.ResponseOrderDTO;
import com.arqsoft.server.Application.Controller.Dto.Request.Order.RequestOrderDTO;
import com.arqsoft.server.Application.Controller.Mapper.Order.OrderMapper;
import com.arqsoft.server.Application.Controller.Mapper.Order.SandwichOrderMapper;
import com.arqsoft.server.Application.Controller.Mapper.Order.StatusMapper;
import com.arqsoft.server.Application.Controller.Mapper.UserMapper;
import com.arqsoft.server.Application.Controller.Port.OrderControllerPort;
import com.arqsoft.server.Domain.Model.Enum.Status;
import com.arqsoft.server.Domain.Model.OrderAggregate.Order;
import com.arqsoft.server.Domain.Model.OrderAggregate.Quantity;
import com.arqsoft.server.Domain.Model.OrderAggregate.SandwichOrder;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Service.Port.OrderService;
import com.arqsoft.server.Service.Port.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderControllerAdapter implements OrderControllerPort {
    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseOrderDTO> createOrder(@RequestBody RequestOrderDTO requestOrderDTO) throws IllegalAccessException {
        //Get user by its domain
        Optional<User> user = userService.getUser(requestOrderDTO.getStudentId());

        // Fail if user does not exist
        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Map<Long, Quantity> sandwichOrderMap = SandwichOrderMapper.ResponseDTOListtoMap(requestOrderDTO.getSandwichOrder());

        // Get SandwichOrder
        SandwichOrder sandwichOrder = orderService.createSandwichOrder(sandwichOrderMap);

        // Fail if Sandwich Order was not possible to create
        if (sandwichOrder.getSandwichOrder().size()==0) {
            return ResponseEntity.noContent().build();
        }

        Order domainOrder = null;
        try {
            domainOrder = OrderMapper.DtoToDomainEntity(requestOrderDTO,user.get(),sandwichOrder);
        }catch (IllegalArgumentException | NullPointerException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Order createdOrder = null;
        try{
             createdOrder = orderService.createOrder(domainOrder);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                OrderMapper.DomainEntityToDto(createdOrder));
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<ResponseOrderDTO> updateOrder(RequestChangeOrderDTO requestChangeOrderDTO,@PathVariable("id") long id) {

        Order order = orderService.getOrderById(id);

        if(order == null){
            return ResponseEntity.notFound().build();
        }

        Status updatedStatus = StatusMapper.stringToStatus(requestChangeOrderDTO.getStatus());

        if(updatedStatus.equals(Status.ERROR)){
            return ResponseEntity.notFound().build();
        }

        Order updatedOrder = orderService.changeOrder(order, updatedStatus);

        ResponseOrderDTO responseOrderDTO = OrderMapper.DomainEntityToDto(updatedOrder);

        return ResponseEntity.ok(responseOrderDTO);
    }

    @Override
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseOrderDTO> getOrderById(@PathVariable("id") long id) {

        try {
            Order order = orderService.getOrderById(id);

            return ResponseEntity.ok().body(
                    OrderMapper.DomainEntityToDto(order));
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ResponseOrderDTO>> getOrders() {
        List<Order> orders = orderService.getOrdersList();

        return ResponseEntity.ok().body(
                OrderMapper.DomainEntitiesToDtoList(orders)
        );
    }
}
