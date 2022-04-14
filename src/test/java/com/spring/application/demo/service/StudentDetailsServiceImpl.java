package com.spring.application.demo.service;
import com.spring.application.demo.dao.LecturerRepository;
import com.spring.application.demo.dao.StudentDetailsRepository;
import com.spring.application.demo.dao.StudentRepository;
import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import com.spring.application.demo.entity.StudentDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDetailsServiceImpl {
    @Autowired
    private StudentDetailServiceImpl service;

    @MockBean
    private StudentDetailsRepository repository;

    @Test
    void findById(){
        StudentDetails studentDetails = new StudentDetails(1,"shivvarevanth@gmail.com",95,"Medak");
        when(repository.findById(1)).thenReturn(Optional.of(studentDetails));
        assertEquals(studentDetails,service.findById(1));

    }
    @Test
    void findByIdException(){
        StudentDetails studentDetails = new StudentDetails(10,"ashwanth123@gmail.com",78,"Hyd");
        when(repository.findById(1)).thenReturn(Optional.of(studentDetails));
        assertThrows(RuntimeException.class,()->service.findById(10));
    }
    @Test
    void save(){
        StudentDetails studentDetails= new StudentDetails(2,"vkm@gmail.com",90,"Warangal");
        service.save(studentDetails);
        verify(repository).save(studentDetails);
    }
    @Test
    void deleteById(){
        service.deleteById(10);
        verify(repository).deleteById(10);
    }
    @Test
    void findAll(){
        StudentDetails studentDetails1= new StudentDetails(2,"vkm@gmail.com",90,"Warangal");
        StudentDetails studentDetails2= new StudentDetails(10,"ashwanth123@gmail.com",78,"Hyd");

        List<StudentDetails> studentDetailsList = new ArrayList<>();
        studentDetailsList.add(studentDetails1);
        studentDetailsList.add(studentDetails2);
        when(repository.findAll()).thenReturn(studentDetailsList);
        assertEquals(studentDetailsList,service.findAll());
    }
    @Test
    void findByStudentId(){
        Student student= new Student(2,"Vk","Mohan");
        StudentDetails studentDetails1= new StudentDetails(2,"vkm@gmail.com",90,"Warangal");
        student.setStudentDetails(studentDetails1);
        when(repository.findAllByStudentId(2)).thenReturn(studentDetails1);
        assertEquals(studentDetails1,service.findAllByStudentId(2));
    }

}
