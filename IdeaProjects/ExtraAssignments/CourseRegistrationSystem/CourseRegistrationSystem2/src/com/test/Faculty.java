package com.test;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Faculty
{
    private String facultyName;
    private int id;
    Scanner sc = new Scanner(System.in);
    // Map<String,List<Faculty> > map = new HashMap<>();

    public Faculty()
    {
    }

    public Faculty(String facultyName, int id)
    {
        this.facultyName = facultyName;
        this.id = id;
    }

    public String getFacultyName()
    {
        return facultyName;
    }

    public void setFacultyName(String facultyName)
    {
        this.facultyName = facultyName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)

    {
        this.id = id;
    }


    public void registerCourse()
    {
        System.out.println("Succssefully registered");
    }

    public void viewCourse(List<Course> course)
    {
        for (int i = 0; i < course.size(); i++)
        {
            System.out.println("Course name:" + course.get(i).getCourseTitle() + "  Course code:" + course.get(i).getCourseCode());
        }
    }

}
