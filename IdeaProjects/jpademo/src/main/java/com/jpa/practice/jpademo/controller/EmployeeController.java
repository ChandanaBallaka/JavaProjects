package com.jpa.practice.jpademo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController
{
    @GetMapping("/employees")
    public String getEmployee()
    {
        return "displaying employees here";
    }

    @GetMapping("/employees/{id}")
    public String getEmployees(@PathVariable("id") Long id)
    {
        return "displaying employee with id" + id;
    }

    //localhost:8080/employees?id=22
    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam("id") int id)
    {
        return "Employee with id " + id + " deleted";
    }
}
