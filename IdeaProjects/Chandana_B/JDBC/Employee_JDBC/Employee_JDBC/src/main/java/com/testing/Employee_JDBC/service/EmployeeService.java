package com.testing.Employee_JDBC.service;

import com.testing.Employee_JDBC.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Employee addEmployee(Employee emp)
    {
        String insert_into_employee = "insert into employee values(?,?,?)";
        return emp;
    }
}
