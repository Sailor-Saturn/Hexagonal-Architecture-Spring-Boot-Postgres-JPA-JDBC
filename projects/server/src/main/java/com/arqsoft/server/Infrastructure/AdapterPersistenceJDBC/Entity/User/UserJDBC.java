package com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user_data")
public class UserJDBC {

    @Id
    private Long id;

    private String name;

    private String password;

    private String usertype;

    public UserJDBC(String name, String password, String usertype) {
        this.name = name;
        this.password = password;
        this.usertype = usertype;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsertype() {
        return usertype;
    }
}
