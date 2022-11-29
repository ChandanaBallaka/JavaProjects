package com.robosoft.Evaluation2.controller;

import com.robosoft.Evaluation2.entity.*;
import com.robosoft.Evaluation2.service.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController
{
    @Autowired
    HospitalRepository hospitalRepository;

    @PostMapping("/addHospitals")
    public void addHospital(@RequestBody Hospital hospital)
    {
        hospitalRepository.addHospital(hospital);
    }

    @PostMapping("/addDepartment")
    public String addDepartment(@RequestBody Department department)
    {
        hospitalRepository.addDepartment(department);
        return "department " + department.getDepartmentName() + " added to Hospital";
    }

    @PostMapping("/addWard")
    public String addWard(@RequestBody Ward ward)
    {
        hospitalRepository.addWard(ward);
        return "ward added";
    }

    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor)
    {
        hospitalRepository.addDoctor(doctor);
        return "Doctor " + doctor.getDoctorName() + " added";
    }

    @DeleteMapping("/deleteDoctor/{doctorId}")
    public String removeDoctor(@PathVariable int doctorId)
    {
        hospitalRepository.removeDoctor(doctorId);
        return "Doctor with Id " + doctorId + " removed successfully";
    }

    @GetMapping("/viewAllWard")
    public List<Ward> vieWAllWards()
    {
        return hospitalRepository.vieWAllWards();
    }

    @GetMapping("/searchPatient/{patientId}")                                                               //searching patient using his id
    public String searchPatient(@PathVariable int patientId)
    {
        Patient patient = hospitalRepository.searchPatient(patientId);
        if(patient == null)
            return "Patient Details are not available";
        return "Patient " + patient.getPatientId() + " is present";
    }

}
