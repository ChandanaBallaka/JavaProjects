package com.test;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
{
    private String studentName;
    private String USN;
    Scanner sc = new Scanner(System.in);

    // Map<String, List<Student>  > map = new HashMap<>();  // one course has many students.
    public Student()
    {
    }

    public Student(String studentName, String USN)
    {
        this.studentName = studentName;
        this.USN = USN;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getUSN()
    {
        return USN;
    }

    public void setUSN(String USN)
    {
        this.USN = USN;
    }

    public void registerCourse()
    {
        System.out.println("Successfully registered");
    }

    public void viewCourse(List<Course> course)
    {
        for (int i = 0; i < course.size(); i++)
        {
            System.out.println("Course name:" + course.get(i).getCourseTitle() + "  Course code:" + course.get(i).getCourseCode());
        }
    }

}
