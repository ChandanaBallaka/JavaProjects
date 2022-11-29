package com.robosoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.setMessgae("I'm object A");
        objA.getMessgae();

        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
        objB.getMessgae();
    }
}
