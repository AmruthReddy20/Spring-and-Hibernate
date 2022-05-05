package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory()  ;
        Session session=factory.getCurrentSession();
        try {
            Student student=new Student("ganesh","dende","ganesh.dende@zemosolabs.com");
            Student student1=new Student("chimtu","mandi","chimtumandi@zemosolabs.com");
            Student student2=new Student("rahul","koneru","rahul.koneru@zemosolabs.com");
            Student student3=new Student("sehwag","virender","sehwag.virender@zemosolabs.com");

            session.beginTransaction();
            System.out.println("Saving student .............");
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
       finally {
            factory.close();
        }

    }
}

