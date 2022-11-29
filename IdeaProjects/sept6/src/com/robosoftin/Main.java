package com.robosoftin;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<String> s1=new ArrayList<>();
        s1.add("Anusha");
        s1.add("Chandana");
        List<String> s2=new ArrayList<>();
        s2.add("Anusha Shetty");
        s2.add("Chandanan B");
        Course obj = new Course();
        Course course1 = new Course("CSE",s1);
        Course course2 = new Course("ECe",s2);
        List<Course> al= new ArrayList<>();
        al.add(course1);
        al.add(course2);
        System.out.println(obj.getCourseName());
        obj.addStud("Anki");
        obj.drop("Anusha");
        System.out.println(obj.numberOfstudents());
    }
}
