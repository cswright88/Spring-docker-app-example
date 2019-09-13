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

    @RequestMapping("/seedPerson")
    public List<Person> person() {
        return personRepository.findAll();
    }
}