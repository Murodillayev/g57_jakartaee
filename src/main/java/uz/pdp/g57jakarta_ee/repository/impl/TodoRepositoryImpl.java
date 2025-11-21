package uz.pdp.g57jakarta_ee.repository.impl;

import jakarta.persistence.*;
import uz.pdp.g57jakarta_ee.config.JpaConfig;
import uz.pdp.g57jakarta_ee.model.Todo;
import uz.pdp.g57jakarta_ee.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

public class TodoRepositoryImpl implements TodoRepository {

    private static TodoRepositoryImpl instance;
    public static TodoRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new TodoRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Todo save(Todo todo) {
        EntityManagerFactory emf = JpaConfig.entityManagerFactory();
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        if (findById(todo.getId()).isPresent()) {
            em.merge(todo);
        } else {
            em.persist(todo);
        }

        em.getTransaction().commit();

        em.close();
        return todo;
    }

    @Override
    public void delete(Todo todo) {
        EntityManagerFactory emf = JpaConfig.entityManagerFactory();
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        String jpql = "delete from Todo t where t.id = :id";
        Query query = em.createQuery(jpql).setParameter("id", todo.getId());
        query.executeUpdate();
        em.getTransaction().commit();

        em.close();

    }

    @Override
    public Optional<Todo> findById(String id) {
        EntityManagerFactory emf = JpaConfig.entityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Todo todo = em.find(Todo.class, id);

        em.close();
        return Optional.ofNullable(todo);
    }

    @Override
    public List<Todo> findAllByUserId(String userId) {
        EntityManagerFactory emf = JpaConfig.entityManagerFactory();
        EntityManager em = emf.createEntityManager();

        TypedQuery<Todo> query = em.createQuery("from Todo t where t.user.id = :userId", Todo.class)
                .setParameter("userId", userId);

        List<Todo> list = query.getResultList();

        em.close();

        return list;
    }
}
