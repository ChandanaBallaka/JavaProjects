package com.robosoft.SpringBootSpringJPA.controller;

import com.robosoft.SpringBootSpringJPA.modal.Employee;
import com.robosoft.SpringBootSpringJPA.service.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmpController
{

    @Autowired
    EmpServiceImpl empServiceImpl;

    @PostMapping("/")
    public void add()
    {
        empServiceImpl.addEmployee();
    }

    @GetMapping("/findall")
    public ArrayList<Employee> getAllEmployee()
    {
        return empServiceImpl.findAllEmployee();
    }

    @GetMapping("/findbyid/{id}")
    public Employee getEmployeeUsingId(@PathVariable long id)
    {
        return empServiceImpl.findAllEmployeeByID(id);
    }

    @DeleteMapping("/delete")
    public void delete()
    {
        empServiceImpl.deleteAllData();
    }
}