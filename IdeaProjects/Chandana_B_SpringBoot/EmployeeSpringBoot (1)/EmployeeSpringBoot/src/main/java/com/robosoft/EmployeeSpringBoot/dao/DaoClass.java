package com.robosoft.EmployeeSpringBoot.dao;

import com.robosoft.EmployeeSpringBoot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoClass implements Dao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> employeeDetails()
    {
        String queryinfo = "select *from employee";
        return jdbcTemplate.query(queryinfo,new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee findEmployeeId(int id)
    {

        String queryinfo = "select *from employee where id=?";
        return (Employee) jdbcTemplate.queryForObject(queryinfo, new Object[] {id},new BeanPropertyRowMapper(Employee.class));
    }

    @Override
    public void deleteEmployee(int id)
    {
        String queryinfo = "delete from employee where id = ?";
        jdbcTemplate.update(queryinfo,new Object[]{id});
    }

    @Override
    public void addEmployee(Employee e)
    {
        String queryinfo = "insert into employee values (?,?,?,?)";
        jdbcTemplate.update(queryinfo,e.getName(),e.getId(),e.getDepartment(),e.getLocation());
    }

    @Override
    public int updateEmployee(int id, Employee employee)
    {
        String queryinfo = "update employee set department=? where id=?";
        return jdbcTemplate.update(queryinfo,employee.getDepartment(),id);
       // return  jdbcTemplate.queryForObject(queryinfo, new Object[] {id}, new BeanPropertyRowMapper(Employee.class));
    }
}
