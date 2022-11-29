package com.robosoft.Evaluation2.service;

import com.robosoft.Evaluation2.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelpdeskRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void registerPatient(Patient p)                //patient registration through helpdesk
    {
        String register_patient = " insert into patient(patientName,patientAge,patientGender,phoneNumber) values(?,?,?,?)";
        jdbcTemplate.update(register_patient,p.getPatientName(),p.getPatientAge(),p.getPatientGender(),p.getPhoneNumber());
    }

    public String bookingAppointment(BookAppointment bookAppointment, int doctorId)       //patient taking appointment through helpdesk  and helpdesk will inform whether doctor is available or not.
    {
        int count = jdbcTemplate.queryForObject("select maxPatient from doctor where doctorId = ?", Integer.class,new Object[]{doctorId});
        if(count>=0)
        {
            String book_appointment = "insert into bookappointment values(?,?,?)";
            jdbcTemplate.update(book_appointment,bookAppointment.getAppointmentNumber(),bookAppointment.getPatientId(),bookAppointment.getDoctorId());
            String update_doctor = "update doctor set maxPatient=? where doctorId=?";
            jdbcTemplate.update(update_doctor,new Object[]{count-1,doctorId});
            return "Appointment Booked Successfully";
        }
        else
        {
            return "Booking denied for today. Please wait..";
        }
    }
    public void generatingMedicalFile(MedicalFile medicalFile)
    {
        String generate_file = "insert into medicalfile(findings,date,patientId) values(?,?,?)";
        jdbcTemplate.update(generate_file, medicalFile.getFindings(), medicalFile.getDate(), medicalFile.getPatientId());
    }

    public void updateMedicalFile(MedicalFile medicalFile,int fileNumber)                               //updating medical file
    {
        String update_file = "Update medicalfile set patientId = ? where fileNumber = ?";
    }

    public MedicalFile searchFileByPatientId(int patientId)                                          //Search medical file  by using patient Id.
    {
        String search_medical_file = "select * from  medicalfile where patientId = ?";
        try
        {
            return jdbcTemplate.queryForObject(search_medical_file, new Object[]{patientId}, new BeanPropertyRowMapper<>(MedicalFile.class));
        }
        catch (Exception e)
        {
            return  null;
        }
    }

    public void makePayment(Payment payment,int appointmentNumber)                   //patient making payment through helpdesk
    {
        String make_payment = "update payment set paymentStatus = ? where appointmentNumber = ?";
        jdbcTemplate.update(make_payment,payment.getPaymentStatus(),appointmentNumber);
    }

    public String admitPatient(AdmittedPatient admittedPatient, int wardNumber)   //admitting patient to the ward and helpdesk will inform whether rooms are available are not.
    {
        int count = jdbcTemplate.queryForObject("select no_of_seats from ward where wardNumber = ?", Integer.class, new Object[]{wardNumber});
        if(count >= 0)
        {
            String admit_patient = "insert into addmittedpatient values(?,?,?,?)";
            jdbcTemplate.update(admit_patient,admittedPatient.getAdmittedId(),admittedPatient.getWardNumber(),admittedPatient.getAppointmentNumber(),admittedPatient.getNo_of_days());
            String update_seatCount = "update ward set no_of_seats = ? where wardNumber = ?";
            jdbcTemplate.update(update_seatCount, new Object[]{count-1, wardNumber});
            return "Beads available patient can be admitted";
        }
        else
        {
            return "Beds not available";
        }
    }

    public void generateRecord(MedicalRecord record)                                 //generating medical file
    {
        String generate_record = "insert into  medicalrecord values(?,?,?)";
        jdbcTemplate.update(generate_record,record.getReportNumber(),record.getDiseaseName(),record.getFileNumber());
    }

    public void updateMedicalRecord(MedicalRecord record, int reportNumber)                               //updating medical file
    {
        String update_file = "Update medicalrecord set diseaseName = ? where reportNumber = ?";
        jdbcTemplate.update(update_file,record.getDiseaseName(),reportNumber);
    }

    public MedicalRecord searchByReportNumber(int reportNumber)
    {
        String search_medical_record = "select * from  medicalrecord where reportNumber = ?";
        try
        {
            return jdbcTemplate.queryForObject(search_medical_record, new Object[]{reportNumber}, new BeanPropertyRowMapper<>( MedicalRecord.class));
        }
        catch (Exception e)
        {
            return  null;
        }
    }


}
