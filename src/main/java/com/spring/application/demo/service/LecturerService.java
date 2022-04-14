package com.spring.application.demo.service;

import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;

import java.util.List;

public interface LecturerService {
    public List<Lecturer> findAll();
    public Lecturer findById(int id);
    public void save(Lecturer lecturer);
    public void deleteById(int id);

}
