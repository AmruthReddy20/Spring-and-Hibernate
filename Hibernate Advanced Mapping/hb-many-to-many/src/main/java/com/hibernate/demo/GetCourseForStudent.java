package com.hibernate.demo;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseForStudent {
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
            int theId=1;
            session.beginTransaction();
            Student student=session.get(Student.class,theId);
            System.out.println("GEtting courses for student"+student);
            System.out.println(student.getCourses());





            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
