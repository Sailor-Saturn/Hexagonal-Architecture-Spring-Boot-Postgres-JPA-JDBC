package com.arqsoft.server.Infrastructure.PersistencePortFactory;

public class PersistenceModuleRetriever {

    public static PersistenceModule getPersistenceModule() {
        String persistenceMode = System.getenv("GORGEOUS_FOOD_PERSISTENCE_MODE");

        if (persistenceMode != null && persistenceMode.equals("jdbc")) {
            return PersistenceModule.JDBC;
        }

        return PersistenceModule.JPA;
    }
}
