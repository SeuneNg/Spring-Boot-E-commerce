package com.example.GestionCommande;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produitcom implements Serializable {
    private Long id;
    private Long produitID;
    private Produit produit;
    private double prix;
    private int quantite;
    private Command command;

    public Produitcom() {
    }

    public Produitcom(Long id, Long produitID, double prix, int quantite, Command command) {
        this.id = id;
        this.produitID = produitID;
        this.prix = prix;
        this.quantite = quantite;
        this.command = command;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduitID(long l) {
        return produitID;
    }

    public void setProduitID(Long produitID) {
        this.produitID = produitID;
    }

    public Long getProduitID() {
        return produitID;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @ManyToOne
    @JsonIgnore
    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }


    @Transient
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Produitcom{" +
                "id=" + id +
                ", produitID=" + produitID +
                ", prix=" + prix +
                ", quantite=" + quantite +
                ", command=" + command +
                '}';
    }
}
