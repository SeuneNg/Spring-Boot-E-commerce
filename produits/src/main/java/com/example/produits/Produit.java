package com.example.produits;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
public class Produit  implements Serializable {

    private Long id;
    private String designation;
    private String description;
    private double price;
    private String filename;
    @Transient
    private int quantite=1;
    public Produit() {
    }

    public Produit(Long id, String designation, String description, double price, String filename) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.price = price;
        this.filename = filename;
    }

    public Produit(Long id, String designation, String description, double price) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.price = price;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }



    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", filename='" + filename + '\'' +
                '}';
    }
}
