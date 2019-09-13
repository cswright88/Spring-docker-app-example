package com.example.demo.controllers;

import com.example.demo.resources.Person;
import com.example.demo.services.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/person")
    public Person person(@RequestParam(value="name", defaultValue="Default Name") String name) {
        Person p1 =  new Person();
        p1.setName(name);

        personRepository.save(p1);
        return p1;
    }
}
