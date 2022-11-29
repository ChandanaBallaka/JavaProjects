package com.robosoft.Evaluation2.service;

import com.robosoft.Evaluation2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addHospital(Hospital hospital)
    {
        String insert_into_hospital = " insert into hospital(hospitalName) values(?)";
        jdbcTemplate.update(insert_into_hospital,hospital.getHospitalName());
    }

    public void addDoctor(Doctor doctor)
    {
        String insert_into_doctor = "insert into doctor(doctorName,maxPatient,departmentName) values(?,?,?)";
        jdbcTemplate.update(insert_into_doctor,doctor.getDoctorName(),doctor.getMaxPatient(),doctor.getDepartmentName());
    }
    public Patient searchPatient(int patientId)                                              //Searching for a patient
    {
        String search_for_patient = "select * from patient where patientId = ?";
        try
        {
            return jdbcTemplate.queryForObject(search_for_patient, new Object[]{patientId}, new BeanPropertyRowMapper<>(Patient.class));
        }
        catch (Exception e)
        {
            return  null;
        }
    }

    public void addDepartment(Department department)
    {
        String insert_into_department = "insert into department values(?,?)";
        jdbcTemplate.update(insert_into_department,department.getDepartmentName(),department.getHospitalName());
    }

    public void addWard(Ward ward)
    {
        String insert_into_ward = "insert into ward values(?,?)";
        jdbcTemplate.update(insert_into_ward,ward.getWardNumber(),ward.getNo_of_seats());
    }

    public List<Ward> vieWAllWards()
    {
        String ward_list = "select * from ward";
        return jdbcTemplate.query(ward_list, new BeanPropertyRowMapper<Ward>(Ward.class));
    }

    public void removeDoctor(int doctorId)
    {
        String remove_doctor = "delete from doctor where doctorId=?";
        jdbcTemplate.update(remove_doctor,doctorId);
    }

}
