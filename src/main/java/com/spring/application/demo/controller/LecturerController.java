package com.spring.application.demo.controller;


import com.spring.application.demo.converter.LecturerConverter;
import com.spring.application.demo.dto.LecturerDTO;
import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import com.spring.application.demo.service.LecturerService;
import com.spring.application.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lecturers")
public class LecturerController {
    private LecturerService service;
    private StudentService studentService;
    private LecturerConverter converter;
    @Autowired
    public LecturerController(LecturerService Service){
        this.service = Service;
    }
    @Autowired
    public void  stuController(StudentService Service){
        this.studentService = Service;
    }
    @Autowired
    public void lecConverter(LecturerConverter lecturerConverter){
        this.converter = lecturerConverter;
    }

    @GetMapping("/list")
    public String listLecturers(Model model){
        List<Lecturer> lecturers= service.findAll();

        List<LecturerDTO> lecturerDTOS = converter.entityToDto(lecturers);
        model.addAttribute("lec",lecturerDTOS);
        return "list-lecturers";
    }
    @GetMapping("/showFormForAdd")
    public String showUpdate(Model model){
        Lecturer lecturer = new Lecturer();
        model.addAttribute("lecturer" , lecturer);
        return "lecturer-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        Lecturer lecturer = service.findById(id);
        model.addAttribute("lecturer",lecturer);
        return "lecturer-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("lecturer") LecturerDTO lecturerDTO){
        Lecturer lecturer = converter.DTOtoEntity(lecturerDTO);
        service.save(lecturer);
        return "redirect:/lecturers/showPrincipleLecturer";

    }
    @GetMapping("/showFormForDelete")
    public String delete(@RequestParam("employeeId") int id){
        service.deleteById(id);
        return "redirect:/lecturers/showPrincipleLecturer";
    }
    @GetMapping("/showStudent")
    public String showStudent(@RequestParam("lecturerId") int id,Model model){
        System.out.println(id);
        List<Student> studentList= studentService.findAllByLecturerId(id);
        System.out.println(studentList);
        if(studentList.size() == 0){
            return "student-notfound";
        }

        model.addAttribute("stu",studentList);
        return "list-student-lecturer";
    }
    @GetMapping("/showPrincipleLecturer")
    public String showLecturerStudent(Model model){
        List<Lecturer> lecturers = service.findAll();
        List<LecturerDTO> lecturerDTOS = converter.entityToDto(lecturers);
        model.addAttribute("lec",lecturerDTOS);
        return "principle-lecturer-list";
    }
    @GetMapping("/principle")
    public String showPrinciple(){
        return "principle";
    }

}