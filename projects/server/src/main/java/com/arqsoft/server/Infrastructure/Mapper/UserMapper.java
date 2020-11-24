package com.arqsoft.server.Infrastructure.Mapper;

import com.arqsoft.server.Application.Controller.Mapper.UserTypeMapper;
import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Domain.Model.UserAggregate.UserId;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.SandwichEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.UserSnapshotEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject.Name;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject.Password;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.UserAggregate.ValueObject.UserType;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.User.UserJDBC;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


public class UserMapper {
    public static UserEntity DomainEntityToJpaEntityWithId(User user) {
        return new UserEntity(
                user.getUserId().getId(),
                new Name(user.getUsername().getName()),
                new Password(user.getPassword().getPassword()),
                new UserType(UserTypeMapper.userTypeToString(user.getUserType()))
        );
    }

    public static UserEntity DomainEntityToJpaEntity (User user){
        if(user.getUserId()==null){
            return new UserEntity(
                    new Name(user.getUsername().getName()),
                    new Password(user.getPassword().getPassword()),
                    new UserType(UserTypeMapper.userTypeToString(user.getUserType()))
            );
        }
        return new UserEntity(
                user.getUserId().getId(),
                new Name(user.getUsername().getName()),
                new Password(user.getPassword().getPassword()),
                new UserType(UserTypeMapper.userTypeToString(user.getUserType()))
        );

    }

    public static UserSnapshotEntity DomainEntityToUserSnapshotEntity(UserEntity userEntity){

        return new UserSnapshotEntity(userEntity.getId(),userEntity.getUsername(),userEntity.getPassword());
    }

    public static User JPAEntityToDomainEntity(UserEntity userEntity) {
        return new User(new UserId(userEntity.getId()),
                new com.arqsoft.server.Domain.Model.ValueObject.Name(userEntity.getUsername().getName()),
                new com.arqsoft.server.Domain.Model.UserAggregate.Password(userEntity.getPassword().getPassword()),
                UserTypeMapper.stringToUserType(userEntity.getUserType().getUserType())
        );
    }

    public static List<User> JPAEntitiesToDomainEntities(List<UserEntity> userEntities) {
        List<User> userList = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            userList.add(JPAEntityToDomainEntity(userEntity));
        });
        return userList;
    }

    public static List<User> JDBCEntitiesToDomainEntities(List<UserJDBC> userList) {
        List<User> userListEntity = new ArrayList<>();
        userList.forEach(userEntity -> {
            userListEntity.add(JDBCEntityToDomainEntity(userEntity));
        });
        return userListEntity;
    }

    private static User JDBCEntityToDomainEntity(UserJDBC userEntity) {
        return new User(
                new UserId(userEntity.getId()),
                new com.arqsoft.server.Domain.Model.ValueObject.Name(userEntity.getName()),
                new com.arqsoft.server.Domain.Model.UserAggregate.Password(userEntity.getPassword()),
                UserTypeMapper.stringToUserType(userEntity.getUsertype())
        );
    }
}
