package com.robosoft.onetomany_uni.controller;

import com.robosoft.onetomany_uni.modal.Person;
import com.robosoft.onetomany_uni.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController
{
    @Autowired
    private PersonService personService;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person)
    {
        return personService.addPerson(person);
    }

    @GetMapping("/persons")
    public List<Person> getPerson()
    {
        return personService.getPerson();
    }
}
