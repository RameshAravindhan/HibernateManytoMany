package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {

            Instructor instructor = new Instructor("Ramesh2", "Aravind", "email.com");

            InstructorDetail instructorDetail = new InstructorDetail("UC2", "Play");


            instructor.setInstructorDetail(instructorDetail);


            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();


//            int id = 3;
//            session.beginTransaction();
//            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
//            System.out.println(instructorDetail);
//            System.out.println(instructorDetail.getInstructor());
//            instructorDetail.getInstructor().setInstructorDetail(null);
//            session.delete(instructorDetail);
//
//            session.getTransaction().commit();
//

        } finally {


            sessionFactory.close();
        }
    }
}