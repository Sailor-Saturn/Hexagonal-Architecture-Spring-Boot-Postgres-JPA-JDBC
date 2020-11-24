package com.arqsoft.server.Domain.Port;

import com.arqsoft.server.Domain.Model.SandwichAggregate.Sandwich.Sandwich;

import java.util.List;
import java.util.Optional;

public interface SandwichPersistencePort {
    Sandwich saveSandwich(Sandwich sandwich);

    Optional<Sandwich> findById(long id);

    List<Sandwich> getAll();

    void deleteById(long id);
}
