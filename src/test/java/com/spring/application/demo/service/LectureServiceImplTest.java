package com.spring.application.demo.service;

import com.spring.application.demo.dao.LecturerRepository;
import com.spring.application.demo.entity.Lecturer;
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
public class LectureServiceImplTest {
    @Autowired
    private LecturerServiceImpl service;

    @MockBean
    private LecturerRepository repository;

   @Test
   void findById(){
       Lecturer lecturer = new Lecturer(1,"Rama","Krishna","EC");
       when(repository.findById(1)).thenReturn(Optional.of(lecturer));
       assertEquals(lecturer,service.findById(1));

   }
   @Test
   void findByIdException(){
       Lecturer lecturer = new Lecturer(100,"Rama","Devi","Maths");
       when(repository.findById(1)).thenReturn(Optional.of(lecturer));
       assertThrows(RuntimeException.class,()->service.findById(100));
   }
   @Test
    void save(){
       Lecturer lecturer = new Lecturer(2,"Vk","Mohan","ED");
       service.save(lecturer);
       verify(repository).save(lecturer);
   }
   @Test
    void deleteById(){
       service.deleteById(4);
       verify(repository).deleteById(4);
   }
   @Test
    void findAll(){
       Lecturer lecturer1 = new Lecturer(10,"Rama","Kanth","Networks");
       Lecturer lecturer2 = new Lecturer(11,"Revathi","Puram","Security");
       List<Lecturer> lecturers = new ArrayList<>();
       lecturers.add(lecturer1);
       lecturers.add(lecturer2);
       when(repository.findAll()).thenReturn(lecturers);
       assertEquals(lecturers,service.findAll());
   }


}
