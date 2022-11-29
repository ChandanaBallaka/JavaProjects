package com.test;

import java.util.List;
import java.util.*;


public class Administrator
{
    private String administratorName;
    private int administratorId;
    //Course courseObj;          //aggregation
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);

    public String getAdministratorName()
    {
        return administratorName;
    }

    public void setAdministratorName(String administratorName)
    {
        this.administratorName = administratorName;
    }

    public int getAdministratorId()
    {
        return administratorId;
    }

    public void setAdministratorId(int administratorId)
    {
        this.administratorId = administratorId;
    }

    void addCourse(List<Course> course)
    {
        System.out.println("Enter the number of courses");
        int count = input.nextInt();
        for (int i = 0; i < count; i++)
        {
            System.out.println("Enter the Course Title");
            String courseTitle = input2.nextLine();
            System.out.println("Enter the Course Code");
            int courseCode = input.nextInt();
            course.add(new Course(courseTitle, courseCode));
        }
    }

    void deleteCourse(List<Course> course)
    {
        int flag = 0;
        System.out.println("Enter the book Tittle to remove");
        String tittle = input.next();
        for (int i = 0; i < course.size(); i++)
        {
            if (course.get(i).getCourseTitle().equalsIgnoreCase(tittle))
            {
                course.remove(i);
                System.out.println("Successfully Deleted");
                flag = 1;
                break;
            }
        }
        if (flag == 0)
            System.out.println("Course  not found");

    }

    public void viewCourse(List<Course> course)
    {
        for (int i = 0; i < course.size(); i++)
        {
            System.out.println("Course name:" + course.get(i).getCourseTitle() + " Course code:" + course.get(i).getCourseCode());
        }

    }
}
