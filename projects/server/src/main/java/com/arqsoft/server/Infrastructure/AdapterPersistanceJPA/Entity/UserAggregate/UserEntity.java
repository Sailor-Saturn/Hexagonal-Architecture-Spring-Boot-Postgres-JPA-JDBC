package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject.Name;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject.Password;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject.UserType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="UserData")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public UserEntity(long id, Name username, Password password, UserType userType) {
        this.Id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public UserEntity(Name username, Password password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public UserEntity(Long id, Name username, Password password, UserType userType) {
        Id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    protected UserEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    @Embedded
    private Name username;

    @Column
    @Embedded
    private Password password;

    @Column
    @Embedded
    private UserType userType;

    public Name getUsername() {
        return username;
    }

    public void setUsername(Name username) {
        this.username = username;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Long getId() {
        return Id;
    }
}
