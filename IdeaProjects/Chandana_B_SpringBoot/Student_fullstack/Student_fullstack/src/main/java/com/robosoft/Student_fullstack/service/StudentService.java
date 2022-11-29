package com.robosoft.Student_fullstack.service;

import com.robosoft.Student_fullstack.modal.Student;

import java.util.List;

public interface StudentService
{
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}

