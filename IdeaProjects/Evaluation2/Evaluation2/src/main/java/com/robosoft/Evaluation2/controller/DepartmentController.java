package com.robosoft.Evaluation2.controller;

import com.robosoft.Evaluation2.entity.Doctor;
import com.robosoft.Evaluation2.service.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController
{
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/searchDoctor/{doctorId}")
    public String searchDoctor(@PathVariable int doctorId)
    {
        Doctor doctor = departmentRepository.searchDoctor(doctorId);
        if(doctor == null)
            return "Doctor Details are not available";
        return "Doctor " + doctor.getDoctorName() + " is present";
    }

    @GetMapping("/viewDoctor")
    public List<Doctor> viewAllDoctor()
    {
        return departmentRepository.viewAllDoctor();
    }
}
