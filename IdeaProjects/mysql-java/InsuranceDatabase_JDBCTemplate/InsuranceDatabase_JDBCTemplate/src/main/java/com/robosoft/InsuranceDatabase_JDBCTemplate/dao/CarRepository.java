package com.robosoft.InsuranceDatabase_JDBCTemplate.dao;

import com.robosoft.InsuranceDatabase_JDBCTemplate.modal.Car;


import java.util.List;

public interface CarRepository
{
    void saveCar(Car car); //add
    Car updateCar(String regNo,Car car);
    Car getByregNo(String regNo); //find by id
    void deleteByNo(String regNo); //delete person
    List<Car> allCar();
}
