package com.arqsoft.server.Application.Controller.Mapper;

import com.arqsoft.server.Domain.Model.Enum.UserType;

public class UserTypeMapper {

    public static UserType stringToUserType(String userType){
        if (userType.equals("STUDENT")){
            return UserType.STUDENT;
        }else if(userType.equals("ADMINISTRATOR")) {
            return UserType.ADMINISTRATOR;
        }else if(userType.equals("VOLUNTEER")){
            return UserType.VOLUNTEER;
        }else {
            throw new IllegalArgumentException ("User type is not valid!");
        }
    }

    public static String userTypeToString (UserType userType){
        if (userType.equals(UserType.STUDENT)){
            return "STUDENT";
        }else if (userType.equals(UserType.ADMINISTRATOR)){
            return "ADMINISTRATOR";
        } else if (userType.equals(UserType.VOLUNTEER)){
            return "VOLUNTEER";
        }else {
            throw new IllegalArgumentException ("User type is not valid!");
        }
    }
}
