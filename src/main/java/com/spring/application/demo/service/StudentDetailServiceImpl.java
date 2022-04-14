package com.spring.application.demo.service;

import com.spring.application.demo.dao.LecturerRepository;
import com.spring.application.demo.dao.StudentDetailsRepository;
import com.spring.application.demo.dao.StudentRepository;
import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import com.spring.application.demo.entity.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDetailServiceImpl implements StudentDetailService {
    private StudentDetailsRepository repository;

    @Autowired
    public StudentDetailServiceImpl(StudentDetailsRepository studentRepository) {
        this.repository =studentRepository;
    }



    @Override
    public List<StudentDetails> findAll() {
        return repository.findAll();
    }

    @Override
    public StudentDetails findById(int theId) {

        Optional<StudentDetails> result= repository.findById(theId);
        StudentDetails studentDetails1 = null;
        if(result.isPresent()){
            studentDetails1= result.get();
        }else{
            throw new RuntimeException("cannot find " +theId);
        }
        return studentDetails1;
    }

    @Override
    public void save(StudentDetails studentDetails) {
        repository.save(studentDetails);
    }

    @Override
    public void deleteById(int id) {
        System.out.println("in service " +
                        id);
        repository.deleteById(id);
    }

    @Override
    public StudentDetails findAllByStudentId(int id) {
        return repository.findAllByStudentId(id);
    }


}

