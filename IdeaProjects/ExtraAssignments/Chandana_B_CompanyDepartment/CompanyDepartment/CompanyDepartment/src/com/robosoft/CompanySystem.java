package com.robosoft;

import java.util.*;

public class CompanySystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner strinput = new Scanner(System.in);

        Company company = new Company("Robosoft");

        List<Department> department = new ArrayList<Department>();
        Department dept = new Department();

        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = new Employee();

        int choice;
        System.out.println("yyy");
        do {
            System.out.println("Enter your choice\n1.Company\n2.Department\n3.Employee\n4.exit");
            choice = input.nextInt();
            int choice2;
            String wish = "";

            do {
                switch (choice) {

                    case 1:
                        System.out.println("Enter your choice\n1.Add Department\n2.Remove Department\n3.Display Departments");
                        choice2 = input.nextInt();
                        switch (choice2) {
                            case 1:
                                company.addDepartment(department);
                                break;
                            case 2:
                                company.removeDepartment(department);
                                break;
                            case 3:
                                company.displayDepartment(department);
                                break;
                        }
                        System.out.println("Do you wish to continue? press yes to proceed");
                        wish = strinput.next();
                        break;

                    case 2:
                        System.out.println("Enter your choice\n1.Add Employee\n2.Remove Employee\n3.View details");
                        choice2 = input.nextInt();

                        switch (choice2) {
                            case 1:
                                dept.addEmployee(employeeList);
                                break;
                            case 2:
                                dept.deleteEmployee(employeeList);
                                break;
                            case 3:
                                dept.viewEmployeeDetails(employeeList);
                                break;
                        }
                        System.out.println("Do you wish to continue? press yes to proceed");
                        wish = strinput.next();
                        break;

                    case 3:
                        System.out.println("You can view the details of employees");
                        employee.viewEmployeeDetails(employeeList);

                        System.out.println("Do you wish to continue? press yes to proceed");
                        wish = strinput.next();
                        break;
                    case 4 :
                    default:
                        System.out.println("exit..Thank You");
                        break;
                }
            } while (wish.equalsIgnoreCase("yes"));
        } while (choice < 4);
    }
}
