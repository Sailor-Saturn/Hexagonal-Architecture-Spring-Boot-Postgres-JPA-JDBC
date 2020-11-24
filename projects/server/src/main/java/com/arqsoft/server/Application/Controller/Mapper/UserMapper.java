package com.arqsoft.server.Application.Controller.Mapper;

import com.arqsoft.server.Application.Controller.Dto.Response.ResponseUserDTO;
import com.arqsoft.server.Application.Controller.Dto.UserDTO;
import com.arqsoft.server.Domain.Model.UserAggregate.Password;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Domain.Model.ValueObject.Name;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static User DtoToDomainEntity(UserDTO userDto) throws IllegalAccessException {

        return new User(new Name(userDto.getUsername()),
                new Password(userDto.getPassword()),
                UserTypeMapper.stringToUserType(userDto.getUserType()));
    }

    public static UserDTO DomainEntityToDto (User user){
        return new UserDTO(user.getUsername().toString(),
                user.getPassword().toString(),
                UserTypeMapper.userTypeToString(user.getUserType()));
    }

    public static ResponseUserDTO DomainEntityToResponseDto(User student) {
        return new ResponseUserDTO(student.getUserId().getId(),student.getUsername().getName(),
                UserTypeMapper.userTypeToString(student.getUserType()));
    }

    public static List<ResponseUserDTO> DomainEntitiesToDTOs(List<User> allUsers) {
        List<ResponseUserDTO> responseUserDTOS = new ArrayList<>();

        allUsers.forEach(user -> {
            responseUserDTOS.add(DomainEntityToResponseDto(user));
                }
        );
        return responseUserDTOS;
    }
}
