package com.spring.application.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="student_details")
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull(message ="required ")
    private int id;
    @Column(name="email")
   @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message ="Unsupported format for email")
    private String email;
    @Min(value = 0,message = "must be greater than 0")
    @Max(value = 100,message = "must be less than or equal to 100")
    @NotNull(message ="required")
    @Column(name="attendance")
    private int attendance;
    @NotNull(message ="required ")
    @Column(name="city")
    private String city;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Student student;
    public StudentDetails() {
    }

    public StudentDetails(int id, String email, int attendance, String city) {
        this.id = id;
        this.email = email;
        this.attendance = attendance;
        this.city = city;
    }

    public StudentDetails(String email, int attendance, String city) {
        this.email = email;
        this.attendance = attendance;
        this.city = city;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", attendance=" + attendance +
                ", city='" + city + '\'' +
                '}';
    }
}
