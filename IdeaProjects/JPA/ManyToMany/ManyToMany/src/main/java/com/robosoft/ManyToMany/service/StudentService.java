package com.robosoft.ManyToMany.service;

import com.robosoft.ManyToMany.entity.Student;
import com.robosoft.ManyToMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> getStudent(int pageNumber, int pageSize)
    {
        Pageable pages= PageRequest.of(pageNumber, pageSize);
        return  studentRepository.findAll(pages).getContent();
    }
}
