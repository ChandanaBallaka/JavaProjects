package com.robosoft.InsuranceDatabase_JDBCTemplate.dao;

import com.robosoft.InsuranceDatabase_JDBCTemplate.modal.Person;

import java.util.List;

public interface PersonRepository
{
    void savePerson(Person person); //add
    Person updatePerson( String driver_id,Person person);
    Person getById( String driver_id); //find by id
    void deleteById( String driver_id); //delete person
    List<Person> allPerson();  //get all employee details
}
