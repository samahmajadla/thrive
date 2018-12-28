package com.demo.thrive.controller;

import com.demo.thrive.model.Activity;
import com.demo.thrive.model.Session;
import com.demo.thrive.model.Trainer;
import com.demo.thrive.repository.SessionRepository;
import com.demo.thrive.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RestController
public class TrainerController {

    private TrainerRepository trainerRepository;

    public TrainerController(@Autowired TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    @PostMapping("/trainer")
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer){
        try {
            Trainer trainerCreated = trainerRepository.save(trainer);
            return new ResponseEntity(trainer, HttpStatus.CREATED);
        } catch (RuntimeException exception){
            return new ResponseEntity(null,  HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/trainer/{id}")
    public ResponseEntity<Activity> getTrainer(@PathVariable Long id){
        Optional<Trainer> trainer = trainerRepository.findById(id);
        if (trainer.isPresent()){
            return new ResponseEntity(trainer, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

}
