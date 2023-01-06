package com.glc.haftasafai.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.haftasafai.entities.Volunteers;
import com.glc.haftasafai.repository.HSRepository;

@RestController
@RequestMapping("/haftasafai/api")
public class Controller {

    @Autowired
    private HSRepository repository;

    @PostMapping("/register") // (POST) https://localhost:8080/books
    public ResponseEntity<Optional> registerVolunteer(@RequestBody Volunteers v) {
        if (repository.findByEmail(v.getEmail()) == null) {
            repository.save(v);
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(v));
        } else {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(Optional.of("This email is already registered!"));
        }

    }

    @PostMapping("/login") // (POST) https://localhost:8080/books
    public ResponseEntity<Optional> loginVolunteer(@RequestBody Volunteers v) {
        Volunteers returnedRecord = repository.findByEmail(v.getEmail());// if true ... email is right
        System.out.println(returnedRecord.getPassword().equals(v.getPassword()));
        if (returnedRecord.getPassword().equals(v.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(returnedRecord));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.of("Incorrect login details"));
        }
    }

    @PutMapping("/join-event") // (POST) https://localhost:8080/books
    public void joinEvent(@RequestBody Volunteers v) {
        Volunteers returnedRecord = repository.findByEmail(v.getEmail()); // if true ... email is right
        returnedRecord.setIsRegistered(v.getIsRegistered());
        repository.save(returnedRecord);

    }

    // @GetMapping("/all") // (GET) https://localhost:8080/books/all

}
