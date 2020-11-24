package com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Repository;

import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.User.UserJDBC;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJDBCRepository extends CrudRepository<UserJDBC, Long> {
}
