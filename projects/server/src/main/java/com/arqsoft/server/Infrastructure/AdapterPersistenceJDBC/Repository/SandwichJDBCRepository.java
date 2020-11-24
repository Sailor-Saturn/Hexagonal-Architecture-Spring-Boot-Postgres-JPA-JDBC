package com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Repository;

import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.Sandwich.SandwichJDBC;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SandwichJDBCRepository extends CrudRepository<SandwichJDBC, Long> {
}
