package com.test;

public class Course
{
    public String courseTitle;
    public int courseCode;

    public Course()
    {
    }


    public Course(String courseTitle, int courseCode)
    {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
    }

    public String getCourseTitle()
    {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle)
    {
        this.courseTitle = courseTitle;
    }

    public int getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(int courseCode)
    {
        this.courseCode = courseCode;
    }
}
