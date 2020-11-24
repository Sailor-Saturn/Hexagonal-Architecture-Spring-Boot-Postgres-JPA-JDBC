package com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Adapter;

import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Domain.Port.UserPersistencePort;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.User.UserJDBC;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Mapper.UserJDBCMapper;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Repository.UserJDBCRepository;
import com.arqsoft.server.Infrastructure.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserJDBCAdapter implements UserPersistencePort {

    @Autowired
    private UserJDBCRepository userJDBCRepository;

    @Override
    public User saveUser(User user) {
        UserJDBC userJDBCToSave = UserJDBCMapper.DomainEntityToJDBCEntity(user);

        UserJDBC savedUserJDBC = userJDBCRepository.save(userJDBCToSave);

        return UserJDBCMapper.JDBCEntityToDomainEntity(savedUserJDBC);
    }

    @Override
    public Optional<User> getUser(Long userId) {
        Optional<UserJDBC> userJDBC = userJDBCRepository.findById(userId);

        if (!userJDBC.isPresent()) {
            return Optional.empty();
        }

        User retrievedDomainUser = UserJDBCMapper.JDBCEntityToDomainEntity(userJDBC.get());

        return Optional.of(retrievedDomainUser);
    }

    @Override
    public List<User> getAll() {
        Iterable<UserJDBC> users = userJDBCRepository.findAll();

        List<UserJDBC> userList = new ArrayList<>();

        users.forEach(userList::add);

        return UserMapper.JDBCEntitiesToDomainEntities(userList);
    }
}
