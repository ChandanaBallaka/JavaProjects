package com.robosoft.onetomany_uni.service;

import com.robosoft.onetomany_uni.modal.Person;
import com.robosoft.onetomany_uni.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService
{
    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person)
    {
        return personRepository.save(person);
    }

    public List<Person> getPerson()
    {
        return personRepository.findAll();
    }
}
