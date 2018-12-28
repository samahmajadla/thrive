package com.demo.thrive.controller;

import com.demo.thrive.model.Activity;
import com.demo.thrive.model.Client;
import com.demo.thrive.model.Session;
import com.demo.thrive.repository.ActivityRepository;
import com.demo.thrive.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class SessionController {

    private SessionRepository sessionRepository;

    public SessionController(@Autowired SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    @PostMapping("/session")
    public ResponseEntity<Session> createSession(@RequestBody Session session){
        try {
            Session sessionCreated = sessionRepository.save(session);
            return new ResponseEntity(sessionCreated, HttpStatus.CREATED);
        } catch (RuntimeException exception){
            return new ResponseEntity(null,  HttpStatus.BAD_REQUEST);
        }    }

    @GetMapping("/session/{id}")
    public ResponseEntity<Session> getSessionsByTrainer(@PathVariable Long id){
        List<Session> sessionsByTrainer = sessionRepository.findByTrainer_TrainerId(id);
        return generateResponse(sessionsByTrainer);
    }


    @GetMapping("/session/{from}-{to}")
    public ResponseEntity<Session> getSessionsBetweenDates(@PathVariable Date from, @PathVariable Date to){
        List<Session> sessionsBetweenDates = sessionRepository.findSessionsBetweenDates(from, to);
        return generateResponse(sessionsBetweenDates);

    }



    private ResponseEntity<Session> generateResponse(List<Session> sessionsFound) {
        if (!sessionsFound.isEmpty()) {
            return new ResponseEntity(sessionsFound, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(sessionsFound, HttpStatus.NO_CONTENT);
        }
    }

}
