package uz.pdp.g57jakarta_ee.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import uz.pdp.g57jakarta_ee.entities.Student;
import uz.pdp.g57jakarta_ee.config.JpaConfig;

import java.util.List;

public class StudentRepository {

    public List<Student> findAll() {
        EntityManagerFactory emf = JpaConfig.entityManagerFactory();
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> query = em.createQuery("from Student", Student.class);

        List<Student> list = query.getResultList();

        em.close();

        return list;
    }

    ;
}
