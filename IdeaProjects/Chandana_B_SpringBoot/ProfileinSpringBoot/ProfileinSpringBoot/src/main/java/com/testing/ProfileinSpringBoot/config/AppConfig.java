package com.testing.ProfileinSpringBoot.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("test")
public class AppConfig
{
    @PostConstruct
    public void print()
    {
        System.out.println("Welcome to Java");
    }
}
