package com.robosoft.StudentMangement_mvc.service;

import com.robosoft.StudentMangement_mvc.entity.Student;

import java.util.List;

public interface StudentService
{
    List<Student> getAllStudent();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);
}
