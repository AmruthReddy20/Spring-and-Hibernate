package com.hibernate.demo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            int theId=1;
            session.beginTransaction();
            Instructor instructor=session.get(Instructor.class,theId);
            Course course=new Course("Air Guitar Ultimate Guide");
            Course course1=new Course("The Pin ball masterclass");
            instructor.add(course);
            instructor.add(course1);
            session.save(course);
            session.save(course1);

            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
