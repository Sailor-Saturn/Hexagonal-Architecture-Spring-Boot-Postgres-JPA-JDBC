package com.arqsoft.server.Application.Controller.Port;

import com.arqsoft.server.Application.Controller.Dto.Response.ResponseUserDTO;
import com.arqsoft.server.Application.Controller.Dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserControllerPort {
    ResponseEntity<UserDTO>  createUser(@RequestBody UserDTO userDTO) throws IllegalAccessException;
    ResponseEntity<ResponseUserDTO> retrieveUser(@PathVariable("id") long id);
    ResponseEntity<List<ResponseUserDTO>> retrieveUsers();
}
