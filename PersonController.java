package com.example.hibernate.controller;

import com.example.hibernate.model.Person;
import com.example.hibernate.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
  @Autowired(required = false)
  PersonRepository personRepository=null;

  //Post addPerson /addPerson @RequestBody
  @PostMapping("/addPerson")
  public ResponseEntity addPerson(@RequestBody Person person){
    personRepository.save(person);
    return new ResponseEntity(person, HttpStatus.CREATED);
  }

  //Put UpdatePerson /UpdatePerson @RequestBody
  @PutMapping("/updatePerson")
  public ResponseEntity updatePerson(@RequestBody Person person){
    personRepository.save(person);
    return new ResponseEntity(person, HttpStatus.ACCEPTED);
  }

  //Patch updatePerson /updatePerson @RequestBody
  @PatchMapping("/updatePerson")
  public ResponseEntity updatePersonDetails(@RequestBody Person person){
    personRepository.save(person);
    return new ResponseEntity(person, HttpStatus.ACCEPTED);
  }

  //Get getPersonById /person @Requestparam
  @GetMapping("/person")
  public Optional<Person> getPersonById(@RequestParam("id") int id){
    return personRepository.findById(id);
  }

  //Get GetAllPersons /persons
  @GetMapping("/persons")
  public List<Person> getAllPersons(){
    return personRepository.findAll();
  }

  //Delete deletePersonById /person @RequestParam
  @DeleteMapping("/deletePerson")
  public String deletePersonById(@RequestParam("id") int id){
    personRepository.deleteById(id);
    return "Person deleted Successfully!";
  }




}
