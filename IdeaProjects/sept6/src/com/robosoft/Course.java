package com.robosoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course
{

         private String courseName;
         private static int stdNo=0;
         List<Student> student = new ArrayList<Student>();

         public Course(String courseName)
         {
                 this.courseName = courseName;
         }

         public String getCourseName()
         {
                return courseName;
         }

         public void setCourseName(String courseName)
         {
                this.courseName = courseName;
         }

         public int getStdNo()
         {
                return stdNo;
         }

        public void setStdNo(int stdNo)
        {
                  this.stdNo = stdNo;
        }

        public List<Student> getStudent()
        {
                    return student;
        }

        public void setStudent(List<Student> student)
        {
                this.student = student;
        }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", student=" + student +
                '}';
    }

    void addStudent(Student std)
        {
                student.add(std);
                stdNo++;
        }
        void removeStudent(Student std)
        {
                student.remove(std);
                stdNo--;
        }
        void display(){
          //  System.out.println("The list of Students is " + Arrays.toString(student.toArray()));
            System.out.println(student);
        }
}
