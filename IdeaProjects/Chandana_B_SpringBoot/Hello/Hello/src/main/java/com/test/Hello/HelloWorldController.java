package com.test.Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController
{
    @RequestMapping("name")
    public String hello()
    {
        return "Hello Chandana B";

    }


}