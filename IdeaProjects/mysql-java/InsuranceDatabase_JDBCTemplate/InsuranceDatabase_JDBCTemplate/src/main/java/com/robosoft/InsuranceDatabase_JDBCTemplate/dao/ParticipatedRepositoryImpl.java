package com.robosoft.InsuranceDatabase_JDBCTemplate.dao;

import com.robosoft.InsuranceDatabase_JDBCTemplate.modal.Participated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ParticipatedRepositoryImpl implements  ParticipatedRepository
{

    private static final String higest_acciodents_for_Rahul = "select count(report_number) from participated inner join person on participated.driver_id = person.driver_id and drivername = (?)";
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public DriverResponse maximumAccidents(String driver_name)
    {
        return jdbcTemplate.queryForObject(higest_acciodents_for_Rahul, new Object[] {driver_name}, new BeanPropertyRowMapper<>(DriverResponse.class));
    }

    public Participated updateParticipated(String regNo, int reportNo, Participated participated)
    {
        String queryInfo = " update participated set damage_amount = ? where reportNo = ? and regNo = ?";
        jdbcTemplate.update(queryInfo,participated.getDamage_amount(),regNo,reportNo);
        return (Participated) jdbcTemplate.queryForObject(queryInfo,new Object[] {reportNo,regNo},new BeanPropertyRowMapper<>(Participated.class));
    }
}
