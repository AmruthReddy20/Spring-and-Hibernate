package com.hibernate.demo.entity;



import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

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
    public Course(){}


    public Course(String title) {
        this.title = title;
    }


}
