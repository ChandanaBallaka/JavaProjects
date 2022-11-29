package com.robosoft;
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class Department
{
    private String deptName;
    Scanner input = new Scanner(System.in); //for int
    Scanner input2 = new Scanner(System.in);//for string
    public Department()
    {

    }

    public Department(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }
    public void addEmployee(List<Employee> employee)
    {
        System.out.println("How many Employee do you want to add?");
        int count = input.nextInt();
        for(int i = 0; i < count; i++)
        {
            System.out.println("Enter the Employee name and id");
            String empName = input2.nextLine();
            int empId = input.nextInt();
            employee.add(new Employee(empName,empId));
        }
        System.out.println("Employee Successfully added");
    }
    public void deleteEmployee(List<Employee> employee)
    {
        int flag = 0;
        System.out.println("Enter the employee Id");
        int id = input.nextInt();
        int size = employee.size();
        for(int i = 0; i < size; i++)
        {
            if( employee.get(i).getEmpId() == id)
            {
                System.out.println("Employee successfully deleted " +  employee.get(i).getEmpId() + " " + employee.get(i).getEmpName());
                employee.remove(i);

                flag = 1;
                break;
            }
        }
        if (flag == 0)
        {
            System.out.println("Employee is not present in the office");
        }

    }
    public void viewEmployeeDetails(List<Employee> e)
    {
        for(int i = 0; i < e.size(); i++)
        {
            System.out.println("Name: " + e.get(i).getEmpName() + "  ID:" + e.get(i).getEmpId());
        }
    }
}
