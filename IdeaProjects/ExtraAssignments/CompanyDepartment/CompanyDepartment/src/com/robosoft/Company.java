package com.robosoft;

import java.util.List;
import java.util.Scanner;

public class Company
{
    private String companyName;
    Scanner input = new Scanner(System.in); //for int
    Scanner input2 = new Scanner(System.in);//for string
    public Company()
    {
    }

    public Company(String companyName)
    {
        this.companyName = companyName;
    }
    public void addDepartment(List<Department> department)
    {
        System.out.println("Enter the number of departments to be added");
        int count = input.nextInt();
        for(int i = 0; i < count; i++)
        {
            System.out.println("Enter the department name");
            String deptName = input2.nextLine();
           department.add(new Department(deptName));
        }
    }
    public void removeDepartment(List<Department> department )
    {
        int flag = 0;
        System.out.println("Enter the department name");
        String deptName = input2.nextLine();
        int length = department.size();
        for(int i = 0; i < length; i++)
        {
            if(department.get(i).getDeptName().equalsIgnoreCase(deptName))
            {
                System.out.println("Department Successfully removed " + department.get(i).getDeptName());
                department.remove(i);

                flag = 1;
                break;
            }
        }
        if(flag == 0)
        {
            System.out.println("Department is not in the list");
        }
    }
    public void displayDepartment(List<Department> department)
    {
        for(Department dept:department)
        {
            System.out.println("name: "+dept.getDeptName());
        }
    }

}
