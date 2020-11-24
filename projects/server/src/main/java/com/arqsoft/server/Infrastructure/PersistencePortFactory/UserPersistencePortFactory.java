package com.arqsoft.server.Infrastructure.PersistencePortFactory;

import com.arqsoft.server.Domain.Port.UserPersistencePort;
import com.arqsoft.server.Infrastructure.AdapterPersistanceJPA.Adapter.UserSpringJpaAdapter;
import com.arqsoft.server.Infrastructure.AdapterPersistenceJDBC.Adapter.UserJDBCAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPersistencePortFactory {

    @Autowired
    private UserJDBCAdapter userJDBCAdapter;

    @Autowired
    private UserSpringJpaAdapter userSpringJpaAdapter;

    public UserPersistencePort retrieveUserPersistencePort() {
        PersistenceModule persistenceModule = PersistenceModuleRetriever.getPersistenceModule();

        if (persistenceModule == PersistenceModule.JDBC) {
            return userJDBCAdapter;
        } else if (persistenceModule == PersistenceModule.JPA) {
            return userSpringJpaAdapter;
        }

        return null;
    }

}
