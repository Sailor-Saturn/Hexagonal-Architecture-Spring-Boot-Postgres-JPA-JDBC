package com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Adapter;

import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Domain.Port.SandwichPersistencePort;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Entity.Sandwich.SandwichJDBC;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Mapper.Sandwich.SandwichJDBCMapper;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Repository.SandwichJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SandwichJDBCAdapter implements SandwichPersistencePort {

    @Autowired
    private SandwichJDBCRepository sandwichJDBCRepository;

    @Override
    public Sandwich saveSandwich(Sandwich sandwich) {
        SandwichJDBC sandwichJDBC = SandwichJDBCMapper.DomainEntityToJDBCEntity(sandwich);

        SandwichJDBC savedSandwich = sandwichJDBCRepository.save(sandwichJDBC);

        return SandwichJDBCMapper.JDBCEntityToDomainEntity(savedSandwich);
    }

    @Override
    public Optional<Sandwich> findById(long id) {
        Optional<SandwichJDBC> sandwichJDBC = sandwichJDBCRepository.findById(id);

        return sandwichJDBC.map(SandwichJDBCMapper::JDBCEntityToDomainEntity);

    }

    @Override
    public List<Sandwich> getAll() {
        List<SandwichJDBC> sandwichJDBCS = new ArrayList<>();

        Iterable<SandwichJDBC> sandwichJDBCList = sandwichJDBCRepository.findAll();

        sandwichJDBCList.forEach(sandwichJDBCS::add);

        return SandwichJDBCMapper.JDBCEntitiesToDomainEntities(sandwichJDBCS);
    }

    @Override
    public void deleteById(long id) {
        sandwichJDBCRepository.deleteById(id);
    }
}
