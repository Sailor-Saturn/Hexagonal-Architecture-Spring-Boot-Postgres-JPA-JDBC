package com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Adapter;

import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;
import com.arqsoft.server.Domain.Port.SandwichPersistencePort;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Entity.SandwichAggregate.Sandwich.SandwichEntity;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Repository.SandwichRepository;
import com.arqsoft.server.Infrastructure.Mapper.Sandwich.SandwichMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SandwichSpringJpaAdapter implements SandwichPersistencePort {

    @Autowired
    private SandwichRepository sandwichRepository;

    @Override
    public Sandwich saveSandwich(Sandwich sandwich) {
        SandwichEntity jpaEntity = SandwichMapper.DomainEntityToJPAEntity(sandwich);

        SandwichEntity createdSandwich = sandwichRepository.save(jpaEntity);

        return SandwichMapper.JPAEntityToDomainEntity(createdSandwich);
    }

    @Override
    public Optional<Sandwich> findById(long id) {
        Optional<SandwichEntity> retrievedSandwich = sandwichRepository.findById(id);

        // No sandwich was found, return empty optional
        return retrievedSandwich.map(SandwichMapper::JPAEntityToDomainEntity);
    }

    @Override
    public List<Sandwich> getAll() {
        List<SandwichEntity> sandwichEntities = sandwichRepository.findAll();

        return SandwichMapper.JPAEntitiesToDomainEntities(sandwichEntities);
    }

    @Override
    public void deleteById(long id) {
        sandwichRepository.deleteById(id);
    }
}
