package com.user.ServerRestTemplate_SpringBoot.controller;

import com.user.ServerRestTemplate_SpringBoot.modal.Employee;
import com.user.ServerRestTemplate_SpringBoot.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee e)
    {
        employeeRepository.addEmployee(e);
        return e;
    }

    @GetMapping("/viewEmployee")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> viewEmployee()
    {
        return employeeRepository.viewEmployee();
    }


    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId)
    {
        employeeRepository.deleteEmployee(empId);
        return "Deleted";
    }
}
