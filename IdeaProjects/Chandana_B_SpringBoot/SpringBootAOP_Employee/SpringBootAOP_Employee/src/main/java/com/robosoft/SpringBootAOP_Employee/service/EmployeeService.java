package com.robosoft.SpringBootAOP_Employee.service;

import com.robosoft.SpringBootAOP_Employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService
{
    List<Employee> employeeList = new ArrayList<>();
    public Employee createEmployee(String name, String empId)
    {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmpId(empId);
        employeeList.add(emp);
        return emp;
    }

    public List<Employee> viewEmployee()
    {
        return employeeList;
    }

    public void deleteEmployee(String empId)
    {
        for(int i = 0; i<employeeList.size(); i++)
        {
            if(employeeList.get(i).getEmpId().equalsIgnoreCase(empId));
            employeeList.remove(employeeList.get(i));
        }
    }

    public void updateEmployee(String name,String empId)
    {
        for(int i =0; i<employeeList.size(); i++)
        {
            if(employeeList.get(i).getEmpId().equalsIgnoreCase(empId))
            {
                Employee emp = new Employee();
                employeeList.get(i).setName(name);
            }
        }
    }
}
