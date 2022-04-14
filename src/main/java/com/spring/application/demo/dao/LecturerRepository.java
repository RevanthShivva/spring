package com.spring.application.demo.dao;

import com.spring.application.demo.entity.Lecturer;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Queue;

public interface LecturerRepository extends JpaRepository<Lecturer,Integer> {

}
