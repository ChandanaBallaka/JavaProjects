package com.excetionhandling.Exception_handling.controller;

import com.excetionhandling.Exception_handling.entity.Employee;
import com.excetionhandling.Exception_handling.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){

        List<Employee> listOfAllEmps = employeeServiceInterface.getAllEmployees();
        return new ResponseEntity<List<Employee>>(listOfAllEmps, HttpStatus.OK);
    }

    @GetMapping("/emp/{empid}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("empid") Long empidL){

        Employee empRetrieved = employeeServiceInterface.getEmpById(empidL);
        return new ResponseEntity<Employee>(empRetrieved, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") Long empidL){

        employeeServiceInterface.deleteEmpById(empidL);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
    }



}
