package com.robosoft.InsuranceDatabase_JDBCTemplate.controller;


import com.robosoft.InsuranceDatabase_JDBCTemplate.dao.PersonRepositoryImpl;
import com.robosoft.InsuranceDatabase_JDBCTemplate.modal.Participated;
import com.robosoft.InsuranceDatabase_JDBCTemplate.modal.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepositoryImpl personRepositoryImpl;


    @GetMapping("/findall")
    public List<Person> allPerson()
    {
        return personRepositoryImpl.allPerson();
    }

    @GetMapping("/findbyid/{driver_id}")
    public Person getById(@PathVariable  String driver_id) {
        return personRepositoryImpl.getById(driver_id);
    }

    @DeleteMapping("/deletebyid/{driver_id}")
    public  void deleteById(@PathVariable  String driver_id)
    {
        personRepositoryImpl.deleteById(driver_id);
    }

    @PostMapping("/addPerson")
    public void savePerson(@RequestBody Person person)
    {
        personRepositoryImpl.savePerson(person);
    }

    @PutMapping("/update")
    public Person updatePerson(@PathVariable  String driver_id,@RequestBody Person person)
    {

        return  personRepositoryImpl.updatePerson(driver_id,person);
    }
    @GetMapping("/count")
    public int count()
    {
        return  personRepositoryImpl.count();
    }

    @PutMapping("/updateParticipated")
    public Participated updateParticipated(@PathVariable String regNo, @PathVariable int reportNo,@RequestBody Participated participated)
    {

        return  personRepositoryImpl.updateParticipated(regNo, reportNo,participated);
    }



}
