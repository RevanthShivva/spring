package com.spring.application.demo.dao;

import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import com.spring.application.demo.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails,Integer> {
    @Query(value = "SELECT * FROM student_details WHERE student_id =?1", nativeQuery = true)
    StudentDetails findAllByStudentId(int id);
}
