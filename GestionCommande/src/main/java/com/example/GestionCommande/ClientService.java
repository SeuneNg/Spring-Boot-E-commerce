package com.example.GestionCommande;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@CrossOrigin("*")
@FeignClient(name = "GESTIONCOMPTES")
public interface ClientService {
    @GetMapping("/listeclients/{id}")
    public Client findClientById(@PathVariable(name="id") Long id);
}
