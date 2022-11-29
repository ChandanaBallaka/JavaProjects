package com.test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

public class EmpDao
{
    JdbcTemplate jdbcTemplate;

    public EmpDao() {
    }

    public EmpDao(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int update1 (Employee e){
        String query="update employee set name=? where id=?";
        return jdbcTemplate.update(query,e.getName(),e.getId());
//        String query="update employee set name=? where id=?";
//        return jdbcTemplate.update(query,e.getName(),e.getId());

//String query="update employee set name=?,salary=? where id=?";
//return jdbcTemplate.update(query,e.getName(),e.getSalary(),e.getId());
    }
    public int update2 (Employee e){
        String query="update employee set name=? where id=?";
        return jdbcTemplate.update(query,e.getName(),e.getId());
//        String query="update employee set name=? where id=?";
//        return jdbcTemplate.update(query,e.getName(),e.getId());

//String query="update employee set name=?,salary=? where id=?";
//return jdbcTemplate.update(query,e.getName(),e.getSalary(),e.getId());
    }

}

