package com.spring.application.demo.service;

import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public void save(Student student);
    public void deleteById(int id);
    public List<Student> findAllByLecturerId(int id);
}
