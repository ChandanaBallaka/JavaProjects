package com.robosoftin;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    int num=0;
    String[] std= new String[10];
    //Student s1 = new Student();
    List<String> stud = new ArrayList<>();
    List<String> course = new ArrayList<>();
    Course(){}
//    public Course(String course, List<String> students) {
//        this.course = course;
//        this.stud=students;
//    }

    public List<String> getCourseName() {
        return course;
    }

    public void setCourseName(List<String> courseName) {
        this.course = courseName;
    }
    void addStud(String std){
        stud.add(std);
    }
    void drop(String std)
    {
        stud.remove(std);
    }
    int numberOfstudents()
    {
        return stud.size();
    }
}
