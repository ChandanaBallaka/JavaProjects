package com.robosoft.InsuranceDatabase_JDBCTemplate.dao;


import com.robosoft.InsuranceDatabase_JDBCTemplate.modal.Participated;
import com.robosoft.InsuranceDatabase_JDBCTemplate.modal.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PersonRepositoryImpl implements PersonRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> allPerson()
    {
        String queryinfo = "select * from person";
        return jdbcTemplate.query(queryinfo,new BeanPropertyRowMapper<Person>(Person.class));
    }

    @Override
    public Person getById( String driver_id) {
        String queryinfo = "select *from person where driver_id=?";
        return  jdbcTemplate.queryForObject(queryinfo, new Object[] {driver_id},new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public void savePerson(Person person)
    {
        String queryinfo = "insert into person values(?,?,?)";
        jdbcTemplate.update(queryinfo,person.getDriverName(),person.getDriver_id(),person.getAddress());
    }

    @Override
    public Person updatePerson( String driver_id,Person person)
    {
        String queryinfo = "update person set driverName=? where driver_id = ?";
        jdbcTemplate.update(queryinfo,person.getDriverName(),driver_id);
        return (Person) jdbcTemplate.queryForObject(queryinfo,new Object[] {driver_id},new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public  void deleteById( String driver_id)
    {
        String querinfo = "delete from person where driver_id = ?";
        jdbcTemplate.update(querinfo,new Object[]{driver_id});
    }

    public int count(){
       String query= "select " +
               "count(distinct driver_id) from participated inner join accident on participated.report_number = accident.report_number and year(accd_date)=\"1989\"";
       return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public Participated updateParticipated( String regNo, int reportNo,Participated participated)
    {
        String queryInfo = " update participated set damage_amount = ? where reportNo = ? and regNo = ?";
        jdbcTemplate.update(queryInfo,participated.getDamage_amount(),regNo,reportNo);
        return (Participated) jdbcTemplate.queryForObject(queryInfo,new Object[] {reportNo,regNo},new BeanPropertyRowMapper<>(Participated.class));
    }

}
