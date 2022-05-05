package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session =factory.getCurrentSession();
        try{
            session.beginTransaction();
            List<Student> studentList=
                    session.createQuery("from Student").list();

            displayStudents(studentList);
            //query to find lastName="koneru"
            System.out.println("Student with last name koneru");
            List<Student> studentList1=session.createQuery("from Student s where s.lastName='koneru'").getResultList();
            displayStudents(studentList1);
            //Query to find lastname lastname="koneru or firstName="ganesh"
            System.out.println("Query to find lastname lastname='koneru' or firstName='donald'");
            List<Student> studentList2 =session.createQuery("from Student s where s.lastName='koneru' or s.firstName='donald'").getResultList();
            displayStudents(studentList2);
            System.out.println("Email ends with @zemosolabs.com");
            List<Student> studentList3=session.createQuery("from Student s where s.email like '%@zemosolabs.com'").list();
            displayStudents(studentList3);
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for(Student student: studentList){
            System.out.println(student);
        }
    }
}
