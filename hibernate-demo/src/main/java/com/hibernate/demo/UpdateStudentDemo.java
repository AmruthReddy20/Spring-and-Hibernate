package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try{
            session.beginTransaction();
            System.out.println("Getting studnet with studnetId");
            Student student =session.get(Student.class,6);
            System.out.println("Updating Student ...........");
            student.setFirstName("ganesh");
            session.getTransaction().commit();
            session= factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("Update Student  s set email='ganesh.virender@gmail.com' where s.id>6").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}
