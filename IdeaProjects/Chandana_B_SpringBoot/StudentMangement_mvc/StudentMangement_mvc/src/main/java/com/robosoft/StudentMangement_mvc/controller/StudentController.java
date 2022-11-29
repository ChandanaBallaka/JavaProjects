package com.robosoft.StudentMangement_mvc.controller;

import com.robosoft.StudentMangement_mvc.entity.Student;
import com.robosoft.StudentMangement_mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController
{
    @Autowired
    private StudentService studentService;

//    public List<Student> getAllStudent()
//    {
//        return studentService.getAllStudent();
//    }

    //handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model)
    {
        model.addAttribute("students",studentService.getAllStudent()); //here students acts as a key(attribute) and studentService.getAllStudent() acts as value
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model)
    {
        //create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model)
    {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,
                                Model model)
    {
        Student existinStudent = studentService.getStudentById(id);
        existinStudent.setId(id);
        existinStudent.setFirstName(student.getFirstName());
        existinStudent.setLastName(student.getLastName());
        existinStudent.setEmail(student.getEmail());

        //save update student object
        studentService.updateStudent(existinStudent);
        return "redirect:/students";
    }

    //handler method to handle student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
       return  "redirect:/students";
    }
}
