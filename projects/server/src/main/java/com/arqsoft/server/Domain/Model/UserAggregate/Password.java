package com.arqsoft.server.Domain.Model.UserAggregate;

import org.apache.commons.lang3.Validate;
import utils.RegexValidator;

public class Password {
    private String password;

    public Password(String password) {
        Validate.notEmpty(password);
        Validate.notNull(password);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return password;
    }
}
