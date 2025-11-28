package uz.pdp.g57jakarta_ee.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import uz.pdp.g57jakarta_ee.config.JpaConfig;
import uz.pdp.g57jakarta_ee.entities.Teacher;

import java.time.LocalDateTime;
import java.util.List;

public class TeacherRepository {

    public List<Teacher> findAll() {
        EntityManager em = JpaConfig.entityManager();
        TypedQuery<Teacher> query = em.createQuery("from Teacher", Teacher.class);

        List<Teacher> list = query.getResultList();

        em.close();
        // main
        return list;
    }

    public void create(String post) {
        EntityManager em = JpaConfig.entityManager();
        em.getTransaction().begin();
        Teacher teacher = new Teacher();
        teacher.setFullName("Hoshimjon");
        teacher.setLevel("PROFESSOR");
        teacher.setSalary(100000000.);
        teacher.setSubject(post);
        teacher.setCreatedAt(LocalDateTime.now());
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();

    }
}
