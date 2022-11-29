package com.robosoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course
{

         private String courseName;
         private static int stdNo=0;
         int idCount = 1;
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
        public String toString()
        {
                return "Course{" +
                        "courseName='" + courseName + '\'' +
                         ", student=" + student +
                         '}';
        }

        void addStudent(String stdName)
        {
            Student st = new Student(idCount,stdName);
                student.add(st);
                idCount++;
                stdNo++;
        }
        void removeStudent(int id)
        {
                for(int i = 0; i< student.size();i++)
                {
                    if(id== student.get(i).getId()){

                        student.remove(i);
                        stdNo--;
                        break;

                    }
                }

        }
        void display()
        {
            for(Student s : student)
            {
                System.out.println(s.getId() + " " + s.getStdName());
            }
        }
}
