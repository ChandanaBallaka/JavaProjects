package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void display(){
        System.out.println("Hello " + message);
    }


    public static void main(String[] args)  {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Hello h = (Hello)context.getBean("myHello");
        h.display();
   }
}
