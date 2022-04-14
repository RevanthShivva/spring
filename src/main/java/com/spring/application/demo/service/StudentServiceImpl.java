package com.spring.application.demo.service;

import com.spring.application.demo.dao.StudentRepository;
import com.spring.application.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        repository = studentRepository;
    }



    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(int theId) {

        Optional<Student> result= repository.findById(theId);
        Student student1=null;
        if(result.isPresent()){
            student1= result.get();
        }else{
            throw new RuntimeException("cannot find " +theId);
        }
        return student1;
    }

    @Override
    public void save(Student theStudent) {
        repository.save(theStudent);
    }

    @Override
    public void deleteById(int id) {
        System.out.println("IN :  " + id);
        repository.deleteById(id);
    }

    @Override
    public List<Student> findAllByLecturerId(int id) {
        return repository.findAllByLecturerId(id);
    }
}
