package com.demo.thrive.controller;

import com.demo.thrive.model.Client;
import com.demo.thrive.repository.ClientRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;


@RestController
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(@Autowired ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @PostMapping("/client")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        try{
            Client clientCreated = clientRepository.save(client);
            return new ResponseEntity<>(clientCreated, HttpStatus.CREATED);
        } catch(RuntimeException exception){
                return returnUnsuccessful();
        }
    }

    @GetMapping("client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        try{
            Optional<Client> client = clientRepository.findById(id);
            if (client.isPresent()){
                return new ResponseEntity<>(client.get(),HttpStatus.FOUND);
            } else{
                return returnUnsuccessful();
            }
        } catch (RuntimeException exception){
            return returnUnsuccessful();
        }
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id){
        Optional<Client> client = clientRepository.findById(id);
        clientRepository.delete(client.get());
        return new ResponseEntity<>(client.get(), HttpStatus.OK);
    }

    private ResponseEntity<Client> returnUnsuccessful() {
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}
