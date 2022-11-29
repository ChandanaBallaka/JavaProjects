package com.robosoft.SpringBootCurdJDBCApplication.controller;

import com.robosoft.SpringBootCurdJDBCApplication.dao.TeacherRepository;
import com.robosoft.SpringBootCurdJDBCApplication.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController
{
    @Autowired
    TeacherRepository  teacherRepository;

    @PostMapping("/")
    public Teacher addTeacher(@RequestBody Teacher teacher){
       return teacherRepository.saveTeacher(teacher);
    }


    @PutMapping("/teacherbyId/{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacher,@PathVariable("id") int id)
    {
        return teacherRepository.updateTeacher(teacher, teacher.getId());
    }

    @GetMapping("/teacher/{id}")
    public Teacher getUser(@PathVariable("id") int id)
    {
        return teacherRepository.getBById(id);
    }

    @GetMapping("/teacher")
    public List<Teacher> getUsers()
    {
        return teacherRepository.allTeacher();
    }

    @DeleteMapping("/teacher/{id}")
    public  String deleteUsers(@PathVariable("id") int id)
    {
        return teacherRepository.deleteById(id);
    }
}
