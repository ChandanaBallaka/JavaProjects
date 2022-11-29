package com.robosoft;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    Course createCourse(String name){
        Course c = new Course(name);
        return c;
    }
        public static void main(String[] args)
            {
                Course course ;
                createCourse("Ram");
                List<Course> courses = new ArrayList<Course>();

                Course course1 = new Course("ECE");
//                Student student = new Student(7,"Chandana");
//                Student student2 = new Student(5,"Deepika");
//                Student student3 = new Student(8,"Yashu");
                course.addStudent("chandana");
                course.addStudent("Deepika");
                course.addStudent("Yashu");
                course.display();
                System.out.println("After removing student");
                course.removeStudent(1);
                course.display();
                System.out.println(course.getCourseName());
                System.out.println(course.getStdNo());
                course.display();
            }
}
