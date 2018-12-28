package com.demo.thrive.controller;

import com.demo.thrive.model.Activity;
import com.demo.thrive.model.Client;
import com.demo.thrive.model.Trainer;
import com.demo.thrive.repository.ActivityRepository;
import com.demo.thrive.repository.ClientRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@RestController
public class ActivityController {

    private ActivityRepository activityRepository;

    public ActivityController(@Autowired ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    @PostMapping("/activity")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity){
        try {
            Activity activityCreated = activityRepository.save(activity);
            return new ResponseEntity(activityCreated, HttpStatus.CREATED);
        } catch (RuntimeException exception){
            return new ResponseEntity(null,  HttpStatus.BAD_REQUEST);
        }    }

    @GetMapping("/activity/{id}")
    public ResponseEntity<Activity> getActivityByTrainer(@PathVariable Long id){
        List<Activity> activities = activityRepository.findByTrainers_TrainerId(id);
        if (!activities.isEmpty()){
            return new ResponseEntity(activities, HttpStatus.FOUND);
        } else{
            return new ResponseEntity(activities, HttpStatus.NO_CONTENT);
        }
    }

}
