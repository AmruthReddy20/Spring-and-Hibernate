package com.hibernate.demo;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                 .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            int theId=11;
            session.beginTransaction();
            Course course=session.get(Course.class,theId);
            System.out.println("Course"+course);
            session.delete(course);





            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
