package com.robosoft.EmployeeSpringBoot.modal;

public class Employee
{
    private String employeeNmae;
    private int employeeId;
    private String department;
    private String location;

    public Employee()
    {
    }

    public String getEmployeeNmae()
    {
        return employeeNmae;
    }

    public void setEmployeeNmae(String employeeNmae)
    {
        this.employeeNmae = employeeNmae;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
