package com.example.GestionCommande;

import java.util.ArrayList;
import java.util.List;

public class OrderForm {
    private Client client=new Client();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderProduct> getProduits() {
        return produits;
    }

    public void setProduits(List<OrderProduct> produits) {
        this.produits = produits;
    }

    private List<OrderProduct> produits=new ArrayList<>();

}

class OrderProduct{
    private Long id;
    private int quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}