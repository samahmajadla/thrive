package com.demo.thrive.controller;

import com.demo.thrive.model.Client;
import com.demo.thrive.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/client")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client clientCreated = clientRepository.save(client);
        if (clientCreated != null){
            return new ResponseEntity<>(clientCreated, HttpStatus.CREATED);
        }else{
            return returnUnsuccessful();
        }
    }

    @GetMapping("client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()){
            return new ResponseEntity<>(client.get(),HttpStatus.FOUND);
        }else{
            return returnUnsuccessful();
        }
    }

    private ResponseEntity<Client> returnUnsuccessful() {
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}
