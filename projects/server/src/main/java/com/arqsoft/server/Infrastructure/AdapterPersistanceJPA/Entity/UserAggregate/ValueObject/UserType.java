package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserType {
    @Column(name ="USERTYPE")
    private String userType;

    protected UserType(){};

    public UserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
