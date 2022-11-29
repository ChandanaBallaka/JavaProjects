package com.testing.SpringBootAOP;

import org.springframework.stereotype.Component;

@Component
public class Employee
{
    public void study()
    {
        // new Human().wakeUp();
        System.out.println("I am working");
    }

    public void studyAnything()
    {
        System.out.println("I will study Physics");
    }

    public int studyAnySubject(int x, int y)
    {
        System.out.println("I will not study Physics");
        return 0;
    }

}
