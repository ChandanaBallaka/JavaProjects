package com.robosoft.InsuranceDatabase_JDBCTemplate.controller;


import com.robosoft.InsuranceDatabase_JDBCTemplate.dao.DriverResponse;
import com.robosoft.InsuranceDatabase_JDBCTemplate.dao.ParticipatedRepository;
import com.robosoft.InsuranceDatabase_JDBCTemplate.dao.ParticipatedRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipatedController
{
    @Autowired
    ParticipatedRepository participatedRepository;

    @GetMapping("/max/{driver_name}")
    public DriverResponse getMax(@PathVariable String driver_name)
    {
        return participatedRepository.maximumAccidents(driver_name);
    }
}
