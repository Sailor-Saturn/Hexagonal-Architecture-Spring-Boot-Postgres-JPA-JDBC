package com.arqsoft.server.Application.Controller.Dto;

import javax.validation.constraints.NotNull;

public class UserDTO {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String userType;

    public UserDTO(@NotNull String username, @NotNull String password, @NotNull String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
