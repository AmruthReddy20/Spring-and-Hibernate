package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session =factory.getCurrentSession();
        try{
            System.out.println("Creating new Student Object");
            Student student=new Student("donald","duck","donald.duck@zemosolabs.com");
            session.beginTransaction();
            session.save(student);
            System.out.println("Student saved :"+student.getId());
            session.getTransaction().commit();
            session= factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting Student with id:"+student.getId());
            Student myStudent=session.get(Student.class, student.getId());
            System.out.println("Get Complete: "+myStudent);
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally {
            factory.close();
        }

    }
}
