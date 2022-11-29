package com.user.ServerRestTemplate_SpringBoot.service;

import com.user.ServerRestTemplate_SpringBoot.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Employee addEmployee(Employee e)
    {
        String insert_into_employee = "insert into employee values(?,?)";
        jdbcTemplate.update(insert_into_employee,e.getEmpId(),e.getEmpName());
        return e;
    }

    public List<Employee> viewEmployee()
    {
        String view_employee = "select * from employee";
        return jdbcTemplate.query(view_employee, new BeanPropertyRowMapper<>(Employee.class));
    }

    public String deleteEmployee(int empId)
    {
        String deleteEmployee = "delete from employee where empId = ?";
        jdbcTemplate.update(deleteEmployee,new Object[]{empId});
        return "Successfully deleted";
    }
}
