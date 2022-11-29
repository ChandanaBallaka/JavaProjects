package com.robosoft;

public class Main
{
        public static void main(String[] args)
            {
                Course course = new Course("CSE");

                Student student = new Student(7,"Chandana");
                Student student2 = new Student(5,"Deepika");
                Student student3 = new Student(8,"Yashu");
                course.addStudent(student);
                course.addStudent(student2);
                course.addStudent(student3);
                course.display();
                System.out.println("After removing student");
                course.removeStudent(student2);
                course.display();
                System.out.println(course.getCourseName());
                System.out.println(course.getStdNo());
                System.out.println(course.getStudent());
            }
}
