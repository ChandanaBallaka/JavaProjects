package com.robosoft.ManyToMany.controller;

import com.robosoft.ManyToMany.entity.Student;
import com.robosoft.ManyToMany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }
    @GetMapping("/students/{pageNumber}/{pageSize}")
    public List<Student> getStudent(@PathVariable int pageNumber, @PathVariable int pageSize)
    {
        return studentService.getStudent(pageNumber, pageSize);
    }
}
