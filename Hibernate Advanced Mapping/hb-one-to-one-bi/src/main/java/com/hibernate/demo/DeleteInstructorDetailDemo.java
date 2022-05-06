package com.hibernate.demo;


import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        Session session =factory.getCurrentSession();
        try{
            session.beginTransaction();
            int theId=6;
            InstructorDetail detail=session.get(InstructorDetail.class,theId);
            System.out.println("Retrieved Instructor detail object");
            System.out.println(detail);
            System.out.println("Retreiving Instructor object");
            Instructor instructor=detail.getInstructor();
            System.out.println("Instructor:"+instructor);
            System.out.println("Deleting instructor"+detail);
            detail.getInstructor().setInstructorDetailId(null);
            session.delete(detail);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
