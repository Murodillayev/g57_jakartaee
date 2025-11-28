package uz.pdp.g57jakarta_ee.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import uz.pdp.g57jakarta_ee.config.JpaConfig;
import uz.pdp.g57jakarta_ee.entities.Student;

import java.time.LocalDateTime;
import java.util.List;

public class StudentRepository {

    public List<Student> findAll() {
        EntityManager em = JpaConfig.entityManager();

        TypedQuery<Student> query = em.createQuery("from Student", Student.class);

        List<Student> list = query.getResultList();

        em.close();

        return list;
    }

    public void create() {
        EntityManager em = JpaConfig.entityManager();
        em.getTransaction().begin();
        Student student = new Student();
        student.setFullName("Mansurbek");
        student.setCourseNumber(2);
        student.setGrade(1.);
        student.setGroupId("12");
        student.setCreatedAt(LocalDateTime.now());
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }
}
