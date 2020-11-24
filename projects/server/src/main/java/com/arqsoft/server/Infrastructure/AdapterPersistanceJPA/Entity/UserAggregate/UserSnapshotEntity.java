package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate;

import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject.Name;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject.Password;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="UserDataSnapshot")
public class UserSnapshotEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Long userId;

    @Column
    @Embedded
    private Name name;

    @Column
    @Embedded
    private Password password;

    public UserSnapshotEntity(Long userId, Name name, Password password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public UserSnapshotEntity() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
