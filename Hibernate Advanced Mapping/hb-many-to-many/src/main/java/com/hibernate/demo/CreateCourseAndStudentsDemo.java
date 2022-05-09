package com.hibernate.demo;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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
            Course newCourse=new Course("Pacman -How to Score Million Points");
            Student newStudent=new Student("ganesh","dende","ganesh.dende@zemosolabs.com");
            Student newStudent1=new Student("suresh","m","suresh.m@zemosolabs.com");
            newCourse.addStudent(newStudent);
            newCourse.addStudent(newStudent1);
            session.save(newStudent);
            session.save(newStudent1);

            System.out.println("Savaing the course"+newCourse);
            session.save(newCourse);




            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
