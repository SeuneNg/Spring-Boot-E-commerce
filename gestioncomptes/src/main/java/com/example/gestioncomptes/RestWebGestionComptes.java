package com.example.gestioncomptes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RestController
public class RestWebGestionComptes {
    private static final Logger log = LoggerFactory.getLogger(RestWebGestionComptes.class);

    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Error")
    @ExceptionHandler(Exception.class)
    public void error() {
    }

    ClientRepository clientRepository;


    @Autowired
    public RestWebGestionComptes(ClientRepository clientRepository) {
        super();
        this.clientRepository = clientRepository;
    }
    private List<Client> clients = new ArrayList<Client>();

    @GetMapping("/listeclients")
    public Iterable<Client> getClients(){
        return clientRepository.findAll();
    }

    @GetMapping(value = "/listeclients/{id}")
    public Client getClientsid(@PathVariable(name="id") Long id){
        return clientRepository.findById(id).get();
    }

    @GetMapping(value = "/parEmail/{email}")
    public ResponseEntity<Client> getClientdes(@PathVariable(name="email") String designation){
        Client client=clientRepository.findByEmailEquals(designation).get(0);
        return ResponseEntity.ok().body(client);
    }

    @PutMapping(value = "/listeclients/{id}")
    public Client updatetClientsid(@PathVariable(name="id") Long id, @RequestBody Client c){
        c.setId(id);
        return clientRepository.save(c);
    }


    @PostMapping("/listeclients")
    public void addClient(@RequestBody Client client) throws Exception {
        clientRepository.save(client);
    }
    @DeleteMapping(value="listeclients:/{id}")
    public void deleteClient(@PathVariable(name="id") Long id){
        clientRepository.deleteById(id);
    }




}
