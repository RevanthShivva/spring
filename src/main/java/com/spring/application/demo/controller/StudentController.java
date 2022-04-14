package com.spring.application.demo.controller;


import com.spring.application.demo.entity.Lecturer;
import com.spring.application.demo.entity.Student;
import com.spring.application.demo.entity.StudentDetails;
import com.spring.application.demo.service.LecturerService;
import com.spring.application.demo.service.StudentDetailService;
import com.spring.application.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService service;
    private LecturerService lecturerService;
    private StudentDetailService detailService;
    @Autowired
    public StudentController(StudentService studentService){
        service = studentService;
    }
    @Autowired
    public void LecturerServiceGetter(LecturerService lecturerService){
        this.lecturerService = lecturerService;
    }
    @Autowired
    public void StudentDetailViewer(StudentDetailService studentDetailService){
        this.detailService = studentDetailService;
    }
    @GetMapping("/list")
    public String listStudents(Model model){
        List<Student> students = service.findAll();

        model.addAttribute("stu",students);
        return "list-students";
    }
    @GetMapping("/showFormForAdd")
    public String showUpdate(@RequestParam("lecturerId") int id, Model model){
        Student student = new Student();
        Lecturer lecturer = lecturerService.findById(id);
        lecturer.add(student);
        student.setLecturer(lecturer);
        model.addAttribute("student" , student);
        return "student-form";
    }

   @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int id, Model model){
        Student student = service.findById(id);
        model.addAttribute("student",student);
        return "student-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("student") Student student){
        service.save(student);
        return "redirect:/students/list";

    }
    @GetMapping("/showFormForDelete")
    public String delete(@RequestParam("studentId") int id){
        service.deleteById(id);
        return "redirect:/students/list";
    }
    @GetMapping("/showStudentDetails")
    public String showStudent(@RequestParam("studentId") int id,Model model){
        System.out.println(id);
        StudentDetails studentDetails= detailService.findAllByStudentId(id);

        model.addAttribute("stud",studentDetails);
        return "list-student-studentDetail";
    }
    @GetMapping("/showPrincipleStudent")
    public String showPrincipleStudent(Model model){
        List<Student> students = service.findAll();

        model.addAttribute("stu",students);
        return "principle-student-list";
    }
    @GetMapping("/listStudentsAuthoried")
    public String listStudentsAuthorised(Model model){
        List<Student> students = service.findAll();

        model.addAttribute("stu",students);
        return "list-students-authorized";
    }
    @GetMapping("/showStudentDetailsAuthorized")
    public String showStudentAuth(@RequestParam("studentId") int id,Model model){
        System.out.println(id);
        StudentDetails studentDetails= detailService.findAllByStudentId(id);

        model.addAttribute("stud",studentDetails);
        return "list-student-studentDetail-authoried";
    }
}
