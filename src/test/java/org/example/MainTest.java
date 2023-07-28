package org.example;

import org.example.model.Employee;
import org.hibernate.Session;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTest {
    private static Session session;

    @BeforeEach
    void setup() {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    @Test
    @Order(1)
    void insertar() {
        session.beginTransaction();
        Employee emp1 = new Employee(5L, "Juan", "El developer");

        session.persist(emp1);
        session.getTransaction().commit();
        session.close();
        System.out.println("Test 1");
    }

    @Test
    @Order(2)
    void retrieve() {

        Employee emp= session.find(Employee.class, 5L);
        System.out.println(emp+" Test2");

    }
    @Test
    @Order(3)
    void update() {
        var emp1 = new Employee(5L,"Juan", "El developer");

        emp1.setId(5L);
        emp1.setName("Actualizado3");
        emp1.setDescription("power");
        session.beginTransaction();
        session.merge(emp1);
        session.getTransaction().commit();
        Employee emp= session.find(Employee.class, 5L);
        System.out.println(emp1);
        Assertions.assertEquals(5L,emp1.getId());

    }
    @Test
    @Order(4)
    void delete() {

        session.beginTransaction();
        session.remove(session.find(Employee.class, 5L));
        session.getTransaction().commit();
        Assertions.assertNull(session.find(Employee.class, 5L));
    }
}
