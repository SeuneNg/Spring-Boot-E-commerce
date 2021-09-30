package com.example.GestionCommande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface CommandRepository extends JpaRepository<Command, Long> {
}
