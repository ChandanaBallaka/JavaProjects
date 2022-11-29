package com.robosoft.SpringBootCurdJDBCApplication.dao;

import com.robosoft.SpringBootCurdJDBCApplication.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TecherRepositoryimpl implements TeacherRepository
{

    private static final String INSERT_USER_QUERY = "INSERT INTO PERSON(id,fname,lname,email) values(?,?,?,?)";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE PERSON SET fname=? WHERE ID=?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM PERSON WHERE ID = ?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM PERSON WHERE ID=?";

    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM PERSON";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Teacher saveTeacher(Teacher teacher)
    {
        jdbcTemplate.update(INSERT_USER_QUERY, teacher.getId(), teacher.getFname(), teacher.getLname(), teacher.getEmail());
        return teacher;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher,int id)
    {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, teacher.getFname(), teacher.getId());
        return teacher;
    }

    @Override
    public Teacher getBById(int id)
    {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
            return new Teacher(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        },id);
    }

    @Override
    public String deleteById(int id)
    {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "User got deletded id" + id;
    }

    @Override
    public List<Teacher> allTeacher() {
        return jdbcTemplate.query(GET_ALL_USERS_QUERY, ((rs, rowNum) -> {
            return new Teacher(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        }));
    }
}
