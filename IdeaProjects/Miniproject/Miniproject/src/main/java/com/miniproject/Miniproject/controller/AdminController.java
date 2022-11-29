package com.miniproject.Miniproject.controller;

import com.miniproject.Miniproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController
{
    @Autowired
    AdminService adminService;

    @PutMapping("/profileVerification/{userId}")

    public String profileVerification(@PathVariable String userId)
    {
        return adminService.profileVerification(userId);
    }
}
