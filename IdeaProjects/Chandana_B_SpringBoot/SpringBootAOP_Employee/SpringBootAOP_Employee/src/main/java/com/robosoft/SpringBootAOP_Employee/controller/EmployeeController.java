package com.robosoft.SpringBootAOP_Employee.controller;


import com.robosoft.SpringBootAOP_Employee.model.Employee;
import com.robosoft.SpringBootAOP_Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add/employee", method = RequestMethod.GET)
    public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

        return employeeService.createEmployee(name, empId);

    }

    @RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
    public String removeEmployee( @RequestParam("empId") String empId) {

        employeeService.deleteEmployee(empId);

        return "Employee removed";
    }

    @RequestMapping(value = "/showEmployee", method = RequestMethod.GET)
    public List<Employee> viewEmployee()
    {
        return employeeService.viewEmployee();
    }



    @RequestMapping(value = "/update/employee", method = RequestMethod.GET)
    public String updateEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId)
    {
        employeeService.updateEmployee(name,empId);
        return "Employee updated successfully";
    }
}
