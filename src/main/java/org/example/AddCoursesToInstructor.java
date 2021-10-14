package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesToInstructor {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {

            int id = 1;
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, id);
            Course course1 = new Course("Course1");
            Course course2 = new Course("Course2");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}