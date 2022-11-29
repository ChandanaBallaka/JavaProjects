package com.testing.Employee_JDBC.controller;

import com.testing.Employee_JDBC.modal.Employee;
import com.testing.Employee_JDBC.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addemp")
    public Employee addEmployee(@RequestBody Employee emp)
    {
        return employeeService.addEmployee(emp);
    }
}
