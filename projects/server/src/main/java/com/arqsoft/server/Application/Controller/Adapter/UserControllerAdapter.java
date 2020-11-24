package com.arqsoft.server.Application.Controller.Adapter;

import com.arqsoft.server.Application.Controller.Dto.Response.ResponseUserDTO;
import com.arqsoft.server.Application.Controller.Dto.UserDTO;
import com.arqsoft.server.Application.Controller.Mapper.UserMapper;
import com.arqsoft.server.Application.Controller.Port.UserControllerPort;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Service.Port.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserControllerAdapter implements UserControllerPort {

    @Autowired
    UserService userService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) throws IllegalAccessException {

        return ResponseEntity.ok().body(
                UserMapper.DomainEntityToDto(
                        userService.saveUser(
                                UserMapper.DtoToDomainEntity(userDto)
                        )));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseUserDTO> retrieveUser(@PathVariable("id") long id){
        Optional<User> user = userService.getUser(id);

        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        ResponseUserDTO responseUserDTO = UserMapper.DomainEntityToResponseDto(user.get());
        return ResponseEntity.ok().body(responseUserDTO);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ResponseUserDTO>> retrieveUsers() {
        List<User> allUsers = userService.getAllUsers();

        List<ResponseUserDTO> userDTOS = UserMapper.DomainEntitiesToDTOs(allUsers);
        return ResponseEntity.ok().body(userDTOS);
    }
}
