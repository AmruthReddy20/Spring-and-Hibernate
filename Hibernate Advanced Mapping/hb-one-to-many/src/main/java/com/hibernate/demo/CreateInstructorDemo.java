package com.hibernate.demo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{

//            Instructor instructor=new Instructor("Chad","Darby","darby@zemosolabs.com");
//            InstructorDetail detail=new InstructorDetail("youtube.com/darby","playing cricker");
            Instructor instructor=new Instructor("Susan","Public","susan.public@zemosolabs.com");
            InstructorDetail detail=new InstructorDetail("youtube.com/susan","Gamer");
            instructor.setInstructorDetailId(detail);
            session.beginTransaction();
            System.out.println("Saving instructor :"+instructor);
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
