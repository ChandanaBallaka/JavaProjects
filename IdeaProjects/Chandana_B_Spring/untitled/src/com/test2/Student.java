package com.test2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
    private String stdName;

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }
    public void display(){
        System.out.println("Student name is " + stdName);
    }
    public static void main(String[] args)  {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");
     Student s = (Student)context.getBean("myStudent");
     s.display();
    }
}
