package com.robosoft.ManyToMany.controller;

import com.robosoft.ManyToMany.entity.Course;
import com.robosoft.ManyToMany.service.CourseService;
import com.robosoft.ManyToMany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController
{
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course)
    {
        return courseService.addCourse(course);
    }
}
