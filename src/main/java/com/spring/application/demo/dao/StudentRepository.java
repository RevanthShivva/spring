package com.spring.application.demo.dao;

import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value ="SELECT * FROM student WHERE lecturer_id =?1",nativeQuery = true)
    public List<Student> findAllByLecturerId(int id);
}
