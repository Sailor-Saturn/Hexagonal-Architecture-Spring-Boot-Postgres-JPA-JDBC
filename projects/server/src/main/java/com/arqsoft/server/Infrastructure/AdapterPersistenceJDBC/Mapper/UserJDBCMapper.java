package com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Mapper;

import com.arqsoft.server.Domain.Model.Enum.UserType;
import com.arqsoft.server.Domain.Model.UserAggregate.Password;
import com.arqsoft.server.Domain.Model.UserAggregate.User;
import com.arqsoft.server.Domain.Model.UserAggregate.UserId;
import com.arqsoft.server.Domain.Model.ValueObject.Name;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.User.UserJDBC;

public class UserJDBCMapper {

    public static User JDBCEntityToDomainEntity(UserJDBC userJDBCEntity) {
        return new User(
                new UserId(userJDBCEntity.getId()),
                new Name(userJDBCEntity.getName()),
                new Password(userJDBCEntity.getPassword()),
                UserType.STUDENT
        );
    }

    public static UserJDBC DomainEntityToJDBCEntity(User user) {
        return new UserJDBC(
                user.getUsername().toString(),
                user.getPassword().toString(),
                user.getUserType().toString()
        );
    }

}
