package com.robosoft.SpringBootSpringJPA.service;

import com.robosoft.SpringBootSpringJPA.modal.Employee;

import java.util.ArrayList;

public interface EmpService
{
    ArrayList<Employee> findAllEmployee();
    Employee findAllEmployeeByID(long id);
    void addEmployee();
    void deleteAllData();
}