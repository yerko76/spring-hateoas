package com.yerko.controller;

import com.yerko.domain.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/demo")
public class PersonController {
    @RequestMapping("/person")
    public HttpEntity<Person> getPerson(){
        Person person = new Person("John","Doe");
        person.add(linkTo(methodOn(PersonController.class)
                .getPerson())
                .withSelfRel());
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping("/persons")
    public HttpEntity<List<Person>> getPersons(){
        List<Person> persons = retrievePersons();
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
    }

    private List<Person> retrievePersons() {
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("John","Doe");
        person1.add(linkTo(methodOn(PersonController.class)
                .getPersons()).withSelfRel());
        Person person2= new Person("Loreim","Ipsum");
        person2.add(linkTo(methodOn(PersonController.class)
                .getPersons()).withSelfRel());
        persons.add(person1);
        persons.add(person2);
        return persons;
    }


}
