package com.robosoft;

import java.util.List;

public class Employee
{
    private String empName;
    private int empId;
    private float empSalary;

    public Employee()
    {
    }

    public Employee(String empName, int empId) {
        this.empName = empName;
        this.empId = empId;
    }

    public Employee(String empName, int empId, float empSalary)
    {
        this.empName = empName;
        this.empId = empId;
        this.empSalary = empSalary;
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }

    public float getEmpSalary()
    {
        return empSalary;
    }

    public void setEmpSalary(float empSalary)
    {
        this.empSalary = empSalary;
    }
    public void viewEmployeeDetails(List<Employee> e)
    {
        for(int i = 0; i < e.size(); i++)
        {
            System.out.println("Name: " + e.get(i).getEmpName() + "  ID:" + e.get(i).getEmpId());
        }
    }
}
