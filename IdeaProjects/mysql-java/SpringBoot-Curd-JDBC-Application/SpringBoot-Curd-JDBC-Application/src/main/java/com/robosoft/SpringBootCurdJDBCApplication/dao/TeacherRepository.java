package com.robosoft.SpringBootCurdJDBCApplication.dao;

import com.robosoft.SpringBootCurdJDBCApplication.entity.Teacher;

import java.util.List;

public interface TeacherRepository
{
    Teacher saveTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    Teacher getBById(int id);
    String deleteById(int id);
    List<Teacher> allTeacher();


}
