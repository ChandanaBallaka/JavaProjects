package com.robosoft.Evaluation2.controller;

import com.robosoft.Evaluation2.entity.MedicalFile;
import com.robosoft.Evaluation2.entity.Payment;
import com.robosoft.Evaluation2.service.DepartmentRepository;
import com.robosoft.Evaluation2.service.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController
{
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("/billing")
    public Payment billing(@RequestBody Payment payment)
    {
        return doctorRepository.billing(payment);
    }

    @GetMapping("/viewMedicalRecords")
    public List<MedicalFile> viewMedicalFiles()
    {
        return doctorRepository.viewMedicalFiles();
    }

    @PostMapping("/generateFile1")
    public String generatingMedicalFile(@RequestBody MedicalFile medicalFile)
    {
        doctorRepository.generatingMedicalFile(medicalFile);
        return "Patient " + medicalFile.getPatientId() + " has medical file ";
    }
}
