package com.spring.application.demo.dto;

import com.spring.application.demo.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class LecturerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String course;
    private List<Student> studentList;

}
