package org.example.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JPAUtil {

    public static final String LEXISLACIONMARIADB = "lexislacionmariadb";
    public static final String LEXISLACIONPOSTGRES = "lexislacion";
    private static final Map<String, EntityManagerFactory> emFactories = new HashMap<>();

    private JPAUtil() {
    }

    private static boolean isEntityManagerFactoryClosed(String unidadPersistencia) {
        EntityManagerFactory emf = emFactories.get(unidadPersistencia);
        return emf == null || !emf.isOpen();
    }

    public static EntityManagerFactory getEmFactory(String unidadPersistencia) {
        if (isEntityManagerFactoryClosed(unidadPersistencia)) {
            synchronized (JPAUtil.class) {
                if (isEntityManagerFactoryClosed(unidadPersistencia)) {
                    try {
                        emFactories.put(unidadPersistencia, Persistence.createEntityManagerFactory(unidadPersistencia));
                    } catch (Exception e) {
                        System.err.println("Failed to create EntityManagerFactory for unit: " + unidadPersistencia);
                        e.printStackTrace();
                    }
                }
            }
        }
        return emFactories.get(unidadPersistencia);
    }

    public static EntityManager getEntityManager(String persistenceUnitName) {
        return getEmFactory(persistenceUnitName).createEntityManager();
    }

    public static void close(String persistenceUnitName) {
        EntityManagerFactory emf = emFactories.get(persistenceUnitName);
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}

