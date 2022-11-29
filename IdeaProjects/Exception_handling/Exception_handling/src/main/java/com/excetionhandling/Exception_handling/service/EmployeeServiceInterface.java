package com.excetionhandling.Exception_handling.service;

import com.excetionhandling.Exception_handling.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface
{

    public Employee addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmpById(Long empidL);

    public void deleteEmpById(Long empidL);

}
