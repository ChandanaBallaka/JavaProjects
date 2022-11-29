package com.example.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController
{
    @RequestMapping("/")
    public String hello()
    {
        return "Hello javaTpoint";

    }

    @RequestMapping("myname")
    public String hello1()
    {
        return "Chandana";
    }

    @RequestMapping("myname/surname")
    public String hello3()
    {
        return "B";

    }
}