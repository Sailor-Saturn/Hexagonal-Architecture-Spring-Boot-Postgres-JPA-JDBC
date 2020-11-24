package com.arqsoft.server.Service.Adapter;

import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Domain.Port.UserPersistencePort;
import com.arqsoft.server.Infrastructure.PersistencePortFactory.UserPersistencePortFactory;
import com.arqsoft.server.Service.Port.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceAdapter implements UserService {

    private UserPersistencePort userPersistencePort;

    @Autowired
    private UserPersistencePortFactory userPersistencePortFactory;

    @PostConstruct
    public void setUserPersistencePort() {
        this.userPersistencePort = userPersistencePortFactory.retrieveUserPersistencePort();
    }

    @Override
    public User saveUser(User user) {
        return this.userPersistencePort.saveUser(user);
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return this.userPersistencePort.getUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userPersistencePort.getAll();
    }
}
