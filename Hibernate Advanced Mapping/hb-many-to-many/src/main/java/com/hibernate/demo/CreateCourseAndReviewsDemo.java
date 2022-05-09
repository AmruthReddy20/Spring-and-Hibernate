package com.hibernate.demo;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                 .addAnnotatedClass(Review.class)
                                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            int theId=1;
            session.beginTransaction();
            Course newCourse=new Course("Pacman -How to Score million Points");
            newCourse.addReview(new Review("Great course....... loved it"));
            newCourse.addReview(new Review("cool course ....... loved it"));
            newCourse.addReview(new Review("...... loved it"));
            System.out.println("Saving Courses"+newCourse);

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
