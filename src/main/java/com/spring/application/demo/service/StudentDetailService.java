package com.spring.application.demo.service;

import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import com.spring.application.demo.entity.StudentDetails;

import java.util.List;

public interface StudentDetailService {
    public List<StudentDetails> findAll();
    public StudentDetails findById(int id);
    public void save(StudentDetails studentDetails);
    public void deleteById(int id);

    StudentDetails findAllByStudentId(int id);

}
