package com.hibernate.demo.entity;

import com.hibernate.demo.entity.InstructorDetail;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "instructor",cascade =  {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Course> courses;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetailId;
    public Instructor(){

    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public void add(Course tempCourse) {

        if (courses == null) {
            courses = new ArrayList<>();
        }

        courses.add(tempCourse);

        tempCourse.setInstructor(this);
    }

    @Override
    public String toString() {
        return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", instructorDetail=" + instructorDetailId + "]";
    }
}
