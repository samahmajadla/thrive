package com.demo.thrive.controller;

import com.demo.thrive.model.Client;
import com.demo.thrive.model.OnlineClientProfile;
import com.demo.thrive.repository.OnlineClientProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OnlineClientProfileController {

    @Autowired
    private OnlineClientProfileRepository onlineClientProfileRepository;

    @PostMapping("/client/online")
    ResponseEntity<OnlineClientProfile> createOnlineClientProfile(@RequestBody OnlineClientProfile onlineClientProfile){
        OnlineClientProfile onlineClientProfileCreated = onlineClientProfileRepository.save(onlineClientProfile);

        if(onlineClientProfileCreated != null){
            return new ResponseEntity<>(onlineClientProfileCreated, HttpStatus.CREATED);
        }else{
            return returnUnsuccessful();
        }
    }



    @GetMapping("client/online/{id}")
    public ResponseEntity<OnlineClientProfile> getOnlineClientProfile(@PathVariable Long id){
        Optional<OnlineClientProfile> client = onlineClientProfileRepository.findById(id);
        if (client.isPresent()){
            return new ResponseEntity<>(client.get(),HttpStatus.FOUND);
        }else{
            return returnUnsuccessful();
        }
    }

    private ResponseEntity<OnlineClientProfile> returnUnsuccessful() {
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}
