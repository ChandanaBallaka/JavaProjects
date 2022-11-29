package com.robosoft.EmployeeSpringBoot.service;

import com.robosoft.EmployeeSpringBoot.modal.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    Scanner input = new Scanner(System.in);
    List<Employee> employee = new ArrayList<>();
    public List<Employee> findAllEmployee()
    {
            if(employee.isEmpty())
            {
                return null;
            }
            else
            {
                return employee;
            }
    }
    public Employee findById(int employeeId)
    {
        Employee emp = employee.stream().filter(e -> e.getEmployeeId() == employeeId).findAny().orElse(null);
        return emp;
    }
    public void delete(int employeeId)
    {
        for(int i = 0 ; i < employee.size(); i++)
        {
            if(employee.get(i).getEmployeeId() == employeeId)
            {
                employee.remove(i);
                break;
            }
        }
        //  Employee emp = employee.stream().filter(e -> e.getEmployeeId() == employeeId).findAny().orElse(null);
        //employee.remove(emp);
    }

    public String updateEmployee(int employeeId, Employee e)
    {

        for(int i = 0 ; i < employee.size(); i++)
        {
            Employee temp = employee.get(i);
          if(temp.getEmployeeId() == employeeId)
         {

               temp.setEmployeeNmae(e.getEmployeeNmae());
                temp.setLocation(e.getLocation());
                temp.setDepartment(e.getDepartment());
                return "SUCCESFULLY UPDATED";
        }
      }
      return "match not found";
    }
    public  void addEmployee(Employee e)
    {
        employee.add(e);
    }

}
