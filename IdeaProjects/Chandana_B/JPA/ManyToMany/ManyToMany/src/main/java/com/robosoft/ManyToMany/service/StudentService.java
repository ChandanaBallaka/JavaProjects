package com.robosoft.ManyToMany.service;

import com.robosoft.ManyToMany.entity.Student;
import com.robosoft.ManyToMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }
}
