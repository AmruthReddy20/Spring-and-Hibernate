package com.hibernate.demo.entity;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
@Data
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="youtube_channel")
    private String youtubeChannel;
    @Column(name="hobby")
    private String hobby;
    @OneToOne(mappedBy = "instructorDetailId",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;
    public InstructorDetail(){}
    public InstructorDetail(String youtubeChannel,String hobby){
        this.hobby=hobby;
        this.youtubeChannel=youtubeChannel;
    }
    public String toString() {
        return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
    }


}
