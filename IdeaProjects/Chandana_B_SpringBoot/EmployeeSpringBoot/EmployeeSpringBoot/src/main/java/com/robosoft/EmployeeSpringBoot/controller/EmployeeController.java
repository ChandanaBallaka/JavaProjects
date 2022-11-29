package com.robosoft.EmployeeSpringBoot.controller;

import com.robosoft.EmployeeSpringBoot.modal.Employee;
import com.robosoft.EmployeeSpringBoot.service.EmployeeService;
import com.robosoft.EmployeeSpringBoot.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/")
    public void addEmployee(@RequestBody Employee e){employeeServiceImpl.addEmployee(e);}

    @GetMapping("/findall")
    public List<Employee> findAllEmployee(){return employeeServiceImpl.findAllEmployee(); }

    @GetMapping("/findbyid/{employeeId}")
    public Employee getById(@PathVariable int employeeId){return  employeeServiceImpl.findById(employeeId);}

    @DeleteMapping("/delete/{employeeId}")
    public void delete(@PathVariable int employeeId){employeeServiceImpl.delete(employeeId); }

    @PutMapping("/update/{employeeId}")
    public String updateEmployee(@PathVariable int employeeId,@RequestBody Employee e){return employeeServiceImpl.updateEmployee(employeeId,e);}

}
