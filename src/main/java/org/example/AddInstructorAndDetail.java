package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddInstructorAndDetail {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {

            Instructor instructor = new Instructor("Ramesh2", "Aravind2", "email2.com");

            InstructorDetail instructorDetail = new InstructorDetail("UChannel4", "jog1");


              instructor.setInstructorDetail(instructorDetail);
            //instructorDetail.setInstructor(instructor);


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