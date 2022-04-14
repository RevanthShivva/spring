package com.spring.application.demo.converter;

import com.spring.application.demo.dto.LecturerDTO;
import com.spring.application.demo.entity.Lecturer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LecturerConverter {
    public LecturerDTO entityToDTO(Lecturer lecturer){
        LecturerDTO lecturerDTO = new LecturerDTO();
        lecturerDTO.setId(lecturer.getId());
        lecturerDTO.setFirstName(lecturer.getFirstName());
        lecturerDTO.setLastName(lecturer.getLastName());
        lecturerDTO.setCourse(lecturer.getCourse());
        lecturerDTO.setStudentList(lecturer.getStudentList());
        return lecturerDTO;
    }
    public Lecturer DTOtoEntity(LecturerDTO lecturerDTO){
        Lecturer lecturer = new Lecturer();
        lecturer.setId(lecturerDTO.getId());
        lecturer.setFirstName(lecturerDTO.getFirstName());
        lecturer.setLastName(lecturerDTO.getLastName());
        lecturer.setCourse(lecturerDTO.getCourse());
        lecturer.setStudentList(lecturerDTO.getStudentList());
        return lecturer;

    }
    public List<LecturerDTO> entityToDto(List<Lecturer> lecturers){
        return lecturers.stream().map(x->entityToDTO(x)).collect(Collectors.toList());
    }
    public List<Lecturer> DtotoEntity(List<LecturerDTO> lecturerDTOS){
        return lecturerDTOS.stream().map(x->DTOtoEntity(x)).collect(Collectors.toList());
    }
}
