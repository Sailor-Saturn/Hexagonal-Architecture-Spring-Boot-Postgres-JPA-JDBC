package com.arqsoft.server.Service.Port;

import com.arqsoft.server.Domain.Model.UserAggregate.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User saveUser(User user);

    public Optional<User> getUser(Long userId);

    public List<User> getAllUsers();
}
