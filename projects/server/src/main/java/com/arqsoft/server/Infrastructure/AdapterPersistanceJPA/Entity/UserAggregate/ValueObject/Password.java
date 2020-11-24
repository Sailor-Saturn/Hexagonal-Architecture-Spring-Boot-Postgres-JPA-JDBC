package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Password {
    @Column(name ="PASSWORD")
    private String password;

    protected Password(){};

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
