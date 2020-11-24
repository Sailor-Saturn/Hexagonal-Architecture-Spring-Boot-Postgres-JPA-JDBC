package com.arqsoft.server.Application.Controller.Dto.Response;

import javax.validation.constraints.NotNull;

public class ResponseUserDTO {
    @NotNull
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String userType;

    public ResponseUserDTO(@NotNull Long id, @NotNull String username, @NotNull String userType) {
        this.id = id;
        this.username = username;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
