package com.spring.application.demo.controller;

import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import com.spring.application.demo.entity.StudentDetails;
import com.spring.application.demo.service.StudentDetailService;
import com.spring.application.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/studentDetails")
public class StudentDetailController {
    private StudentDetailService service;
    private StudentService studentService;
    @Autowired
    public StudentDetailController(StudentDetailService studentService){
        this.service = studentService;
    }
    @Autowired
    public void setStudentDetails(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/list")
    public String listStudentDetails(Model model){
        List<StudentDetails> studentDetails= service.findAll();

        model.addAttribute("stud",studentDetails);
        return "list-studentDetails";
    }
    @GetMapping("/showFormForAdd")
    public String showUpdate(@RequestParam("studentId") int id ,Model model){
        StudentDetails studentDetails = new StudentDetails();
        Student student= studentService.findById(id);
        student.add(studentDetails);
        studentDetails.setStudent(student);
        model.addAttribute("studentDetails" , studentDetails);
        return "studentDetail-form";
    }
   /* @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentDetailId") int id, Model model){
        StudentDetails studentDetails = service.findById(id);
        model.addAttribute("studentDetails",studentDetails);
        return "studentDetail-form";
    }*/
   @GetMapping("/showFormForUpdate")
   public String showFormUpdate(@RequestParam("studentId") int id ,Model model){
       Student student= studentService.findById(id);

       StudentDetails studentDetails = student.getStudentDetails();
     //  System.out.println("1" +studentDetails);
      // int i = studentDetails.getId();
       service.deleteById(student.getStudentDetails().getId());

       StudentDetails studentDetails1= new StudentDetails();
       student.add(studentDetails1);
       studentDetails1.setStudent(student);
       model.addAttribute("studentDetails" , studentDetails1);
       return "studentDetailUpdate-form";
   }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("studentDetails") StudentDetails student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "studentDetail-form";
        }
        service.save(student);
        return "redirect:/studentDetails/list";

    }
    @GetMapping("/showFormForDelete")
    public String delete(@RequestParam("studentDetailId") int id){
        service.deleteById(id);
        return "redirect:/studentDetails/list";
    }

}