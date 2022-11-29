package com.test.RestTemplate_SpringBoot.controller;


import com.test.RestTemplate_SpringBoot.modal.Employee;
import com.test.RestTemplate_SpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-client")
public class EmployeeResource
{
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public String addEmp(@RequestBody Employee e)
    {
        return employeeService.saveEmp(e);
    }

    @GetMapping
    public List<Employee> viewEmployee()
    {
        return employeeService.viewEmployee();
    }
}
