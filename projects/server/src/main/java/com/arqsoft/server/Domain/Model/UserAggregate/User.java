package com.arqsoft.server.Domain.Model.UserAggregate;

import com.arqsoft.server.Domain.Model.Enum.UserType;
import com.arqsoft.server.Domain.Model.ValueObject.Name;

import java.util.Objects;

public class User {
    private UserId userId;
    private Name username;
    private Password password;
    private UserType userType;

    public User(Name username, Password password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public User(UserId userId, Name username, Password password, UserType userType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public Name getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                userType == user.userType;
    }

    @Override
    public String toString() {
        return "User{" +
                ", username=" + username +
                ", password=" + password +
                ", userType=" + userType +
                '}';
    }
}
