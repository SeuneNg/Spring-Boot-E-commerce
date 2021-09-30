package com.example.GestionCommande;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin("*")
@FeignClient(name="PRODUITS")
public interface ProduitService {
    @GetMapping(value = "/produits/{id}")
    public Produit findProduitById(@PathVariable(name = "id") Long id);
}
