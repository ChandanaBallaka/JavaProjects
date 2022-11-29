package com.robosoft.ManyToMany.controller;

import com.robosoft.ManyToMany.entity.Student;
import com.robosoft.ManyToMany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
