package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Adapter;

import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Domain.Port.UserPersistencePort;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserSnapshotEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository.UserRepository;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository.UserSnapshotRepository;
import com.arqsoft.server.Infrastructure.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserSpringJpaAdapter implements UserPersistencePort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSnapshotRepository userSnapshotRepository;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity= UserMapper.DomainEntityToJpaEntity(user);

        userRepository.save(userEntity);

        UserSnapshotEntity userSnapshot = UserMapper.DomainEntityToUserSnapshotEntity(userEntity);

        userSnapshotRepository.save(userSnapshot);
        return user;
    }

    @Override
    public Optional<User> getUser(Long userId) {
        Optional<UserEntity> retrievedUser = userRepository.findById(userId);

        return retrievedUser.map(UserMapper::JPAEntityToDomainEntity);
    }

    @Override
    public List<User> getAll() {
        List<UserEntity> userEntities = userRepository.findAll();

        return UserMapper.JPAEntitiesToDomainEntities(userEntities);
    }


}
