package com.robosoft;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class S1 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student s = (Student) context.getBean("myStudent");
        s.display();
    }
}