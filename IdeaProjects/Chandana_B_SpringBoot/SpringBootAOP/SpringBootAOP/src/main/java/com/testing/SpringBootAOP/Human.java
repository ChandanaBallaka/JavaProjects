package com.testing.SpringBootAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Human
{

 //  @After("execution( public void com.testing.SpringBootAOP.Student.study())")  //It will call study() method present in student class only
 //  @After("execution( public void study*())")   //* is wildcard (It will call every method that will start from study)
   @After("myPointCuts()")    //any return type with methods starting from study will call
//   @After("execution( public void com.testing.SpringBootAOP.Employee.study())")
   // @Before("execution( public void study())")
   //  @After("execution( public void study())")       // cross cutting concern(It will call study() method present in entire application
    public void wakeUp(JoinPoint j)     //advise
    {
        System.out.println("Good Morning!!!..." + j.getTarget().getClass().getName());
    }

    @Before("myPointCuts()")
    public void sleep()     //advise
    {
        System.out.println("Good Night!!!...");
    }

    @Pointcut("execution( public * study*())")
    public void myPointCuts()
    {

    }
}
