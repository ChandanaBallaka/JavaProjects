package com.robosoft.Evaluation2.controller;

import com.robosoft.Evaluation2.entity.*;
import com.robosoft.Evaluation2.service.HelpdeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelpdeskController
{
    @Autowired
    HelpdeskRepository helpdeskRepository;

    @PostMapping("/addPatients")
    public String registerPatient(@RequestBody Patient p)                           //patient registration through helpdesk
    {
        helpdeskRepository.registerPatient(p);
        return "Patient with name " + p.getPatientName() + " Registered successfully";
    }

   @GetMapping("/bookingappointment/{doctorId}")
    public String bookingAppointment(@RequestBody BookAppointment bookAppointment, @PathVariable int doctorId)             //patient getting appointment through helpdesk
    {
        return helpdeskRepository.bookingAppointment(bookAppointment,doctorId);

    }

    @PostMapping("/generateFile")
    public String generatingMedicalFile(@RequestBody MedicalFile medicalFile)
    {
        helpdeskRepository.generatingMedicalFile(medicalFile);
        return "Patient " + medicalFile.getPatientId() + " has medical file ";
    }

    @PutMapping("/updateFile/{fileNumber}")
    public void updateMedicalFile(@RequestBody MedicalFile medicalFile, @PathVariable int fileNumber)
    {
        helpdeskRepository.updateMedicalFile(medicalFile,fileNumber);
    }

    @GetMapping("/searchFile/{patientId}")                                                           //searching medical file.
    public String searchFileByPatientId(@PathVariable int patientId)
    {
        MedicalFile file = helpdeskRepository.searchFileByPatientId(patientId);
        if (file == null)
            return "Medical file with file number  is present";
        return "Medical file with file number  is present";
    }

    @GetMapping("/admitPatient/{wardNumber}")
    public String admitPatient(@RequestBody AdmittedPatient admittedPatient, @PathVariable int wardNumber)
    {
        return helpdeskRepository.admitPatient(admittedPatient,wardNumber);
    }

    @PutMapping("/makingPayment/{appointmentNumber}")
    public String makePayment(@RequestBody Payment payment,@PathVariable int appointmentNumber)
    {
        helpdeskRepository.makePayment(payment,appointmentNumber);
        return  "*****PAYMENT SUCCESSFUL*****";
    }

    @PostMapping("/generateRecord")
    public String generateRecord(@RequestBody MedicalRecord record)
    {
        helpdeskRepository.generateRecord(record);
        return "Records added.";
    }

    @PutMapping("/updateRecord/{reportNumber}")
    public void updateMedicalRecord(@RequestBody MedicalRecord record, @PathVariable int reportNumber)
    {
        helpdeskRepository.updateMedicalRecord(record,reportNumber);
    }

    @GetMapping("/searchRecord/{reportNumber}")
    public String searchByReportNumber(@PathVariable int reportNumber)
    {
        MedicalRecord record = helpdeskRepository.searchByReportNumber(reportNumber);
        if(record == null)
            return "Records you are looking for is not available";
        return "Medical record with report number " + record.getReportNumber() + " is present";
    }

}
