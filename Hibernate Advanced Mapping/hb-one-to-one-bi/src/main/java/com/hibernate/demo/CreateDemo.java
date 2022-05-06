package com.hibernate.demo;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{

//            Instructor instructor=new Instructor("Chad","Darby","darby@zemosolabs.com");
//            InstructorDetail detail=new InstructorDetail("youtube.com/darby","playing cricker");
            Instructor instructor=new Instructor("Madhu","Patel","madhu.patel@zemosolabs.com");
            InstructorDetail detail=new InstructorDetail("youtube.com/madhu","Guitar");
            instructor.setInstructorDetailId(detail);
            session.beginTransaction();
            System.out.println("Saving instructor :"+instructor);
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally {
            factory.close();
        }
    }
}
