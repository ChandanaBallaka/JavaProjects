package com.springsecurity.Springsecurity_methodlevel.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping("/foradmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String forAdmin()
    {
        return "this page is accessible only by admin";
    }

    @GetMapping("/foruser")
    @PreAuthorize("hasRole('USER')")
    public String forUser()
    {
        return "this page is accessible only by user";
    }
}
