package com.robosoft.ManyToMany.service;

import com.robosoft.ManyToMany.entity.Course;
import com.robosoft.ManyToMany.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService
{
    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course)
    {
        return courseRepository.save(course);
    }
}
