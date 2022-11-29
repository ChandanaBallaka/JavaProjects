package com.robosoft.Evaluation2.service;

import com.robosoft.Evaluation2.entity.MedicalFile;
import com.robosoft.Evaluation2.entity.Payment;
import com.robosoft.Evaluation2.entity.Ward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Payment billing(Payment payment)                      //generating billing amount.
    {
        String bill = "insert into payment values(?,?,?)";
        jdbcTemplate.update(bill,payment.getAmount(),payment.getAppointmentNumber(),payment.getPaymentStatus());
        bill = "select *from payment where  appointmentNumber=?";
        return jdbcTemplate.queryForObject(bill, new Object[] {payment.getAppointmentNumber()}, new BeanPropertyRowMapper<>(Payment.class));
    }

    public void generatingMedicalFile(MedicalFile medicalFile)
    {
        String generate_file = "insert into medicalfile(findings,date, patientId) values(?,?,?)";     //doctor reciveing medical file by helpdesk.
        jdbcTemplate.update(generate_file,medicalFile.getFindings());
    }

    public List<MedicalFile> viewMedicalFiles()               //doctor viewing medical files of patient.
    {
        String view_file = "select * from  medicalfile";
        return jdbcTemplate.query(view_file, new BeanPropertyRowMapper<MedicalFile>(MedicalFile.class));
    }
}
