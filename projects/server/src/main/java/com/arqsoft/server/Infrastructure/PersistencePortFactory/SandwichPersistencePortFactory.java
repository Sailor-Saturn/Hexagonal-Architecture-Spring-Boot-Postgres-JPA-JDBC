package com.arqsoft.server.Infrastructure.PersistencePortFactory;

import com.arqsoft.server.Domain.Port.SandwichPersistencePort;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Adapter.SandwichSpringJpaAdapter;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Adapter.SandwichJDBCAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SandwichPersistencePortFactory {

    @Autowired
    private SandwichJDBCAdapter sandwichJDBCAdapter;

    @Autowired
    private SandwichSpringJpaAdapter sandwichSpringJpaAdapter;

    public SandwichPersistencePort retrieveSandwichPersistencePort() {
        PersistenceModule persistenceModule = PersistenceModuleRetriever.getPersistenceModule();

        if (persistenceModule == PersistenceModule.JDBC) {
            return sandwichJDBCAdapter;
        } else if (persistenceModule == PersistenceModule.JPA) {
            return sandwichSpringJpaAdapter;
        }

        return null;
    }

}
