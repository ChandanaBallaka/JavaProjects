package com.robosoft.Evaluation2.service;

import com.robosoft.Evaluation2.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Doctor searchDoctor(int doctorId)                        // department can search doctor by his Id.
    {
        String search_for_doctor = "select * from doctor where doctorId = ?";
        try
        {
            return jdbcTemplate.queryForObject(search_for_doctor, new Object[]{doctorId}, new BeanPropertyRowMapper<>(Doctor.class));
        }
        catch (Exception e)
        {
            return  null;
        }
    }

    public List<Doctor> viewAllDoctor()                    //department viewing list of doctors
    {
        String doctor_list = "select * from doctor";
        return jdbcTemplate.query(doctor_list, new BeanPropertyRowMapper<Doctor>(Doctor.class));
    }
}
