package com.robosoft.EmployeeSpringBoot.dao;

import com.robosoft.EmployeeSpringBoot.entity.Employee;

import java.util.List;

public interface Dao
{
    List<Employee> employeeDetails();

    Employee findEmployeeId(int id);

    void deleteEmployee(int id);

    void addEmployee(Employee e);

   int updateEmployee(int id, Employee employee);
}
