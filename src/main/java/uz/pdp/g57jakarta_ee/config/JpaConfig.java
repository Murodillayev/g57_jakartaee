package uz.pdp.g57jakarta_ee.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConfig {

    private static EntityManagerFactory entityManagerFactory;

    private JpaConfig() {

    }

    public static EntityManagerFactory entityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("g54_orm");
        }
        return entityManagerFactory;
    }


}
