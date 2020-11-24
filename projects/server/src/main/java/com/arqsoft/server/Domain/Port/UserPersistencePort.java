package com.arqsoft.server.Domain.Port;

import com.arqsoft.server.Domain.Model.UserAggregate.User;

import java.util.List;
import java.util.Optional;

public interface UserPersistencePort {
    User saveUser(User user);

    Optional<User> getUser(Long userId);

    List<User> getAll();
}
