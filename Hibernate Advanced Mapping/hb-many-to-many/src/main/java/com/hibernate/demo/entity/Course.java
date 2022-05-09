package com.hibernate.demo.entity;



import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    int courseId;
    @Column(name="title")
    private String title;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviewList;
    @ManyToMany(fetch = FetchType.LAZY,cascade =  {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student> students;

    public Course(){}


    public Course(String title) {
        this.title = title;
    }
    public void addReview(Review review){
        if(reviewList==null){
            reviewList=new ArrayList<Review>();

        }
        reviewList.add(review);
    }
    public void addStudent(Student newStudent){
        if(students==null){
            students=new ArrayList<>();
        }
        students.add(newStudent);
    }


}
