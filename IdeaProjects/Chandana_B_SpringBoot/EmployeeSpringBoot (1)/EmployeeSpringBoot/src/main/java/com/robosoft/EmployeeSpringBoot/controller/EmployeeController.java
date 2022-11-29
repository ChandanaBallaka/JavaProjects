package com.robosoft.EmployeeSpringBoot.controller;

import com.robosoft.EmployeeSpringBoot.dao.DaoClass;
import com.robosoft.EmployeeSpringBoot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    DaoClass daoclass;

    @GetMapping("/findall")
    // public List<Employee> employeeDetails(){ return daoclass.employeeDetails();}
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> list = daoclass.employeeDetails();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Employee> findEmployeeId(@PathVariable int id) {
        // return daoclass.findEmployeeId(id);
        Employee employee = daoclass.findEmployeeId(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employee));
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
        try {
            daoclass.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return ResponseEntity.of(Optional.of(id));
        return null;
    }

    @PostMapping("/addemployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
        Employee emp = null;
        try {
            daoclass.addEmployee(e);
            System.out.println(e);
            return ResponseEntity.of(Optional.of(emp));
        } catch (Exception exp) {
            exp.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        try {
            this.daoclass.updateEmployee(id, employee);

                return ResponseEntity.ok().body(employee);
            }catch(Exception exp){
                exp.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
//            return employee;

    }

}
