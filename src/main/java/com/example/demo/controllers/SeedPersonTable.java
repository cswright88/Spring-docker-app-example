package com.example.demo.controllers;

import com.example.demo.resources.Person;
import com.example.demo.services.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeedPersonTable {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/seed")
    public List<Person> seedPerson() {
        Person p1 =  new Person();
        p1.setName("Scott Wright");
        personRepository.save(p1);
        Person p2 =  new Person();
        p2.setName("Chris Wright");
        personRepository.save(p2);

        return personRepository.findAll();
    }
}