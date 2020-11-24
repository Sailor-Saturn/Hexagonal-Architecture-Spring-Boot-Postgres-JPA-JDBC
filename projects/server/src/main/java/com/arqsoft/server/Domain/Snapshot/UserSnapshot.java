package com.arqsoft.server.Domain.Snapshot;

import com.arqsoft.server.Domain.Model.UserAggregate.Password;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Domain.Model.ValueObject.Name;

public class UserSnapshot {

    private User base;
    private Name name;
    private Password password;

    public UserSnapshot(User base) {
        this.base = base;
        this.name = base.getUsername();
        this.password = base.getPassword();
    }

    public Name getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }
}
