package com.robosoft.EmployeeSpringBoot.service;

import com.robosoft.EmployeeSpringBoot.modal.Employee;

import java.util.HashSet;
import java.util.List;

public interface EmployeeService
{
    List<Employee> findAllEmployee();
    Employee findById(int employeeId);
    void delete(int employeeId);

    void addEmployee(Employee e);
    String updateEmployee(int employeeId, Employee e);
}
