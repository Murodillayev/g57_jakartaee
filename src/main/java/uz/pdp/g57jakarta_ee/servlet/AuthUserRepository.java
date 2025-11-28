package uz.pdp.g57jakarta_ee.servlet;

import jakarta.persistence.EntityManager;
import uz.pdp.g57jakarta_ee.config.JpaConfig;
import uz.pdp.g57jakarta_ee.entities.AuthUser;

public class AuthUserRepository {


    public AuthUser create(AuthUser authUser) {
        EntityManager em = JpaConfig.entityManager();
        em.getTransaction().begin();
        em.persist(authUser);
        em.getTransaction().commit();
        em.close();

        return authUser;

    }
}
