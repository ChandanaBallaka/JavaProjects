package com.testing.oneToOne_BiDirectional.service;

import com.testing.oneToOne_BiDirectional.modal.Person;
import com.testing.oneToOne_BiDirectional.repository.PersonRepository;
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

//    public int getPersonById(int personId)
//    {
//        personRepository.findAllById(personId).orElse(null);
//    }
}
