package com.spring.application.demo.service;

import com.spring.application.demo.dao.LecturerRepository;
import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LecturerServiceImpl implements LecturerService {
    private LecturerRepository repository;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.repository =lecturerRepository;
    }



    @Override
    public List<Lecturer> findAll() {
        return repository.findAll();
    }

    @Override
    public Lecturer findById(int theId) {

        Optional<Lecturer> result= repository.findById(theId);
        Lecturer lecturer1 = null;
        if(result.isPresent()){
            lecturer1= result.get();
        }else{
            throw new RuntimeException("cannot find " +theId);
        }
        return lecturer1;
    }

    @Override
    public void save(Lecturer theLecturer) {
        repository.save(theLecturer);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }


}
