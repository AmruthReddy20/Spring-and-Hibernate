package com.hibernate.demo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                 .addAnnotatedClass(Review.class)
                                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            int theId=10;
            session.beginTransaction();
            Course newCourse=session.get(Course.class,theId);
            System.out.println("Course is "+newCourse);
            System.out.println("Reviews are"+newCourse.getReviewList());


            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
