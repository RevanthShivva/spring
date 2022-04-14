package com.spring.application.demo.service;
import com.spring.application.demo.dao.StudentRepository;
import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
    @Autowired
    private StudentServiceImpl service;

    @MockBean
    private StudentRepository repository;

    @Test
    void findById(){
        Student student = new Student(100,"Rohith","Shivva");
        when(repository.findById(100)).thenReturn(Optional.of(student));
        assertEquals(student,service.findById(100));

    }
    @Test
    void findByIdException(){
        Student student = new Student(107,"Devi",null);
        when(repository.findById(1)).thenReturn(Optional.of(student));
        assertThrows(RuntimeException.class,()->service.findById(107));
    }
    @Test
    void save(){
        Student student= new Student(2,"Vk","Mohan");
        service.save(student);
        verify(repository).save(student);
    }
    @Test
    void deleteById(){
        service.deleteById(10);
        verify(repository).deleteById(10);
    }
    @Test
    void findAll(){
        Student student1 = new Student(10,"Rama","Kanth");
        Student student2 = new Student(11,"Revathi","Puram");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        when(repository.findAll()).thenReturn(studentList);
        assertEquals(studentList,service.findAll());
    }
    @Test
    void findByLecturerId(){
        Lecturer lecturer = new Lecturer(2,"Vk","Mohan","ED");
        Student student1 = new Student(10,"Rama","Kanth");
        Student student2 = new Student(11,"Revathi","Puram");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        lecturer.setStudentList(studentList);
        when(repository.findAllByLecturerId(2)).thenReturn(studentList);
        assertEquals(studentList,service.findAllByLecturerId(2));
    }
}
