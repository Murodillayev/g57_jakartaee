package uz.pdp.g57jakarta_ee.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import uz.pdp.g57jakarta_ee.config.JpaConfig;
import uz.pdp.g57jakarta_ee.model.AuthUser;
import uz.pdp.g57jakarta_ee.repository.AuthUserRepository;

import java.util.Optional;

public class AuthUserRepositoryImpl implements AuthUserRepository {
    private static AuthUserRepositoryImpl instance;

    public static AuthUserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new AuthUserRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Optional<AuthUser> findByUsername(String username) {
        EntityManager entityManager = JpaConfig.entityManagerFactory().createEntityManager();
        TypedQuery<AuthUser> query = entityManager.createNamedQuery("User.find", AuthUser.class)
                .setParameter("username", username);

//        Query query = entityManager.createNativeQuery("select * from auth_user where username=:username", AuthUser.class)
//                .setParameter("username", username);

        AuthUser authUser = (AuthUser) query.getSingleResult();
        return Optional.ofNullable(authUser);
    }

    @Override
    public AuthUser save(AuthUser authUser) {

        EntityManager entityManager = JpaConfig.entityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Optional<AuthUser> byId = findById(authUser.getId());

        if (byId.isPresent()) {
            entityManager.merge(authUser);
        } else {
            entityManager.persist(authUser);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

        return authUser;
    }

    @Override
    public Optional<AuthUser> findById(String id) {
        EntityManager entityManager = JpaConfig.entityManagerFactory().createEntityManager();
        AuthUser authUser = entityManager.find(AuthUser.class, id);
        entityManager.close();
        return Optional.ofNullable(authUser);
    }
}
