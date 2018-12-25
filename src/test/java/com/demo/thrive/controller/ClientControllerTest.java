package com.demo.thrive.controller;

import com.demo.thrive.model.Client;
import com.demo.thrive.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientControllerTest {

    ClientRepository mockRepository;

    String email = "email";
    String fname = "fname";
    String lname = "lname";
    String phone = "phone";
    long id = Integer.toUnsignedLong(13);

    Client clientPassedIn;
    Client clientToReturn_success;

    @BeforeEach
    public void setUp(){
        mockRepository = mock(ClientRepository.class);
        clientPassedIn = new Client();
        clientToReturn_success = new Client();

        clientPassedIn.setEmail(email);
        clientPassedIn.setFirstName(fname);
        clientPassedIn.setLastName(lname);
        clientPassedIn.setPhone(phone);

        clientToReturn_success.setEmail(email);
        clientToReturn_success.setFirstName(fname);
        clientToReturn_success.setLastName(lname);
        clientToReturn_success.setPhone(phone);
        clientToReturn_success.setId(id);
    }

    @Test
    public void test_createClient_success() {
        when(mockRepository.save(clientPassedIn)).thenReturn(clientToReturn_success);

        ClientController clientController = new ClientController(mockRepository);

        ResponseEntity<Client> responseEntity = clientController.createClient(clientPassedIn);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Client client = responseEntity.getBody();
        assertThat(client.getEmail()).isEqualTo(email);
        assertThat(client.getFirstName()).isEqualTo(fname);
        assertThat(client.getLastName()).isEqualTo(lname);
        assertThat(client.getPhone()).isEqualTo(phone);
        assertThat(client.getId()).isEqualTo(id);
    }

    @Test
    public void test_createClient_failure() {
        when(mockRepository.save(clientPassedIn)).thenReturn(clientToReturn_success);

        ClientController clientController = new ClientController(mockRepository);

        ResponseEntity<Client> responseEntity = clientController.createClient(clientPassedIn);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Client client = responseEntity.getBody();
        assertThat(client.getEmail()).isEqualTo(email);
        assertThat(client.getFirstName()).isEqualTo(fname);
        assertThat(client.getLastName()).isEqualTo(lname);
        assertThat(client.getPhone()).isEqualTo(phone);
        assertThat(client.getId()).isEqualTo(id);
    }

    @Test
    public void test_getClient_success() {
        when(mockRepository.findById(id)).thenReturn(Optional.of(clientToReturn_success));

        ClientController clientController = new ClientController(mockRepository);

        ResponseEntity<Client> responseEntity = clientController.getClient(id);


        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
        Client client = responseEntity.getBody();
        assertThat(client.getEmail()).isEqualTo(email);
        assertThat(client.getFirstName()).isEqualTo(fname);
        assertThat(client.getLastName()).isEqualTo(lname);
        assertThat(client.getPhone()).isEqualTo(phone);
        assertThat(client.getId()).isEqualTo(id);
    }

    @Test
    public void test_getClient_failure(){

    }
}