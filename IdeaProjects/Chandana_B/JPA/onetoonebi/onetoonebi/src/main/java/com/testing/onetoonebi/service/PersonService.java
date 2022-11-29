package com.testing.onetoonebi.service;

import com.testing.onetoonebi.modal.Person;
import com.testing.onetoonebi.repository.PersonRepository;
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
