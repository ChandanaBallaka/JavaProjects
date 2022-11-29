package com.robosoft.InsuranceDatabase_JDBCTemplate.dao;


import com.robosoft.InsuranceDatabase_JDBCTemplate.modal.Car;
import com.robosoft.InsuranceDatabase_JDBCTemplate.modal.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRepositoryImpl implements CarRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Car> allCar(){
        String queryinfo = "select *from car";
        return jdbcTemplate.query(queryinfo,new BeanPropertyRowMapper<Car>(Car.class));
    }

    public Car getByregNo(String regNo) {
        String queryinfo = "select *from car where regNo=?";
        return (Car) jdbcTemplate.queryForObject(queryinfo, new Object[] {regNo},new BeanPropertyRowMapper<>(Car.class));
    }

    public void saveCar(Car car)
    {
        String queryinfo = "insert into car values(?,?,?)";
        jdbcTemplate.update(queryinfo,car.getModel(), car.getRegNo(), car.getYear());
    }

    public Car updateCar(String regNo,Car car)
    {
        String queryinfo = "update car set model=? where regNo = ?";
        jdbcTemplate.update(queryinfo,car.getModel(),regNo);
        return (Car) jdbcTemplate.queryForObject(queryinfo,new Object[] {regNo},new BeanPropertyRowMapper<>(Car.class));
    }
    public  void deleteByNo(String regNo)
    {
        String querinfo = "delete from car where regNo = ?";
        jdbcTemplate.update(querinfo,new Object[]{regNo});
    }


}
