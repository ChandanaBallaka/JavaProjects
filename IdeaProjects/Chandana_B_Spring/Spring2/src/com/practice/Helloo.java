package com.practice;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Helloo {

    public static void main(String[] args)  {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Demo h = (Demo)context.getBean("myHelloo");
        h.display();
    }
}
