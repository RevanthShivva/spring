package com.spring.application.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull(message = "is required")
    private int id;
    @Column(name ="first_name")
    @NotNull(message = "is required")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="course")
    @NotNull(message = "is required")
    private String course;
    @OneToMany(mappedBy = "lecturer",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Student> studentList;
    public Lecturer(){}

    public Lecturer(int id, String firstName, String lastName, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public Lecturer(String firstName, String lastName, String course) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public void add(Student tempStudent){
        if(studentList==null){
            studentList = new ArrayList<>();
        }
        studentList.add(tempStudent);
        tempStudent.setLecturer(this);
    }

}
