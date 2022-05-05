package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try{
            session.beginTransaction();
            System.out.println("Getting studnet with studnetId");
            Student student =session.get(Student.class,6);
            System.out.println("Deleting Student ...........");
            session.delete(student);
            //delete student id=5
            System.out.println("Deleting Student id =5");
            session.createQuery("delete from Student s where s.id=5").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}
