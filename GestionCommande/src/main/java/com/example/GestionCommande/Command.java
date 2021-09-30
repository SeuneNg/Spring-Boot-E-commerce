package com.example.GestionCommande;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Command implements Serializable {
    private Long id;
    private Date datecom;
    private Long ClientID;
    private Client client;
    private Double totale;
    private List<Produitcom> produitcoms=new ArrayList<Produitcom>();
    public Command() {
    }

    public Command(Long id, Date datecom, Long clientID, List<Produitcom> produitcoms) {
        this.id = id;
        this.datecom = datecom;
        ClientID = clientID;
        this.produitcoms = produitcoms;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatecom() {
        return datecom;
    }

    public void setDatecom(Date datecom) {
        this.datecom = datecom;
    }

    public Double getTotale() {
        return totale;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }

    public Long getClientID() {
        return ClientID;
    }

    public void setClientID(Long clientID) {
        ClientID = clientID;
    }

    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public List<Produitcom> getProduitcoms() {
        return produitcoms;
    }

    public void setProduitcoms(List<Produitcom> produitcoms) {
        this.produitcoms = produitcoms;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;

        Command command = (Command) o;

        if (getId() != null ? !getId().equals(command.getId()) : command.getId() != null) return false;
        if (getDatecom() != null ? !getDatecom().equals(command.getDatecom()) : command.getDatecom() != null)
            return false;
        if (getClientID() != null ? !getClientID().equals(command.getClientID()) : command.getClientID() != null)
            return false;
        if (getClient() != null ? !getClient().equals(command.getClient()) : command.getClient() != null) return false;
        return getProduitcoms() != null ? getProduitcoms().equals(command.getProduitcoms()) : command.getProduitcoms() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDatecom() != null ? getDatecom().hashCode() : 0);
        result = 31 * result + (getClientID() != null ? getClientID().hashCode() : 0);
        result = 31 * result + (getClient() != null ? getClient().hashCode() : 0);
        result = 31 * result + (getProduitcoms() != null ? getProduitcoms().hashCode() : 0);
        return result;
    }

    @Transient
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", datecom='" + datecom + '\'' +
                ", ClientID=" + ClientID +
                ", produitcoms=" + produitcoms +
                '}';
    }
}
