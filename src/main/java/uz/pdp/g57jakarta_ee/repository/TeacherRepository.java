package uz.pdp.g57jakarta_ee.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import uz.pdp.g57jakarta_ee.entities.Teacher;
import uz.pdp.g57jakarta_ee.config.JpaConfig;

import java.util.List;


public class TeacherRepository {

    public List<Teacher> findAll() {
        EntityManagerFactory emf = JpaConfig.entityManagerFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Teacher> query = em.createQuery("from Teacher", Teacher.class);

        List<Teacher> list = query.getResultList();

        em.close();

        return list;
    };
}
