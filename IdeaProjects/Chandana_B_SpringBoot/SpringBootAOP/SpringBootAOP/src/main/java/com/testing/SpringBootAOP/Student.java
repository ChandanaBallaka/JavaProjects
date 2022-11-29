package com.testing.SpringBootAOP;

import org.springframework.stereotype.Component;

@Component
public class Student
{
    public void study()
    {
       // new Human().wakeUp();
        System.out.println("I am studying java");
    }

    public void studySomething()
    {
        System.out.println("I will study maths tonight");
    }
}
