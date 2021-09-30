package com.example.produits;

import org.aspectj.weaver.bcel.UnwovenClassFileWithThirdPartyManagedBytecode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaType.*;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class RestWebProduits {
    private static final Logger log = LoggerFactory.getLogger(RestWebProduits.class);

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Error")
    @ExceptionHandler(Exception.class)
    public void error() {
    }

    ProduitRepository produitRepository;

    @Autowired
    public RestWebProduits(ProduitRepository produitRepository) {
        super();
        this.produitRepository= produitRepository;
    }

    @GetMapping(value = "/listeproduits")
    public List<Produit> getProduits(){
        return produitRepository.findAll();
    }

    @GetMapping(value = "/listeproduits/{id}")
    public Produit getProduitsid(@PathVariable(name="id") Long id){
        return produitRepository.findById(id).get();
    }

    @GetMapping(value = "/parNom/{designation}")
    public Produit getProduitsdes(@PathVariable(name="designation") String designation){
        return produitRepository.findByDesignationContains(designation).get(0);
    }
    @GetMapping(value = "/produitPhoto/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable(name = "id") Long id) throws Exception{
        Produit p=produitRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/files/"+p.getFilename()));

    }
    @PutMapping(value="listeproduits/{id}")
    public Produit updateProduit(@PathVariable(name="id") Long id, @RequestBody Produit p){
        p.setId(id);
        return produitRepository.save(p);
    }

    @PostMapping(value = "/listeproduits")
    public void addProduits(@RequestBody Produit produits) throws Exception {
        produitRepository.save(produits);
    }

    @DeleteMapping(value="listeproduits:/{id}")
    public void deleteproduit(@PathVariable(name="id") Long id){
        produitRepository.deleteById(id);
    }

}
