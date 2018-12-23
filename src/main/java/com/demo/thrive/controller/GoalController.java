package com.demo.thrive.controller;

import com.demo.thrive.model.Goal;
import com.demo.thrive.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoalController {

    @Autowired
    GoalRepository goalRepository;

    @PostMapping("/client/{id}/goal")
    ResponseEntity<Goal> createGoal(@RequestBody Goal goal){
        Goal savedGoal = goalRepository.save(goal);
        if(savedGoal!=null){
            return new ResponseEntity<>(savedGoal, HttpStatus.CREATED);
        } else{
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/client/{id}/goal")
    ResponseEntity<List<Goal>> getGoals(@PathVariable Long id){
        List<Goal> goals = goalRepository.findByClientProfileId(id);
        if(!goals.isEmpty()){
            return new ResponseEntity<>(goals, HttpStatus.FOUND);
        }else{
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }

    }
}
