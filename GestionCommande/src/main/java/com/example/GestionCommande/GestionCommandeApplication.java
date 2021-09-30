package com.example.GestionCommande;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class GestionCommandeApplication {

	private static final Logger log = LoggerFactory.getLogger(GestionCommandeApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(GestionCommandeApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CommandRepository commandRepository, ProduitcomRepository produitcomRepository,
							ClientService clientService, ProduitService produitService){
		return args -> {
			Client cl1= clientService.findClientById(1L);
			System.out.println("*************************");
			System.out.println("ID-Client:"+cl1.getId());
			System.out.println("Nom-Client:"+cl1.getNom());
			System.out.println("Prenom-Client:"+cl1.getPrenom());
			System.out.println("*************************");
			Command C1= new Command();
			C1.setClientID(cl1.getId());
			C1.setDatecom(new Date());

			Produit pd1=produitService.findProduitById(1L);
			System.out.println("*************************");
			System.out.println("ID-Produit:"+pd1.getId());
			System.out.println("Nom-Produit:"+pd1.getDesignation());
			System.out.println("Prix-Produit:"+pd1.getPrice());
			System.out.println("*************************");
			Produitcom P1= new Produitcom();
			P1.setQuantite(3);
			P1.setPrix(pd1.getPrice()*P1.getQuantite());
			P1.setProduitID(pd1.getId());
			C1.getProduitcoms().add(P1);

			P1.setCommand(C1);

			Produit pd2=produitService.findProduitById(2L);
			System.out.println("*************************");
			System.out.println("ID-Produit:"+pd2.getId());
			System.out.println("Nom-Produit:"+pd2.getDesignation());
			System.out.println("Prix-Produit:"+pd2.getPrice());
			System.out.println("*************************");
			Produitcom P2= new Produitcom();
			P2.setQuantite(3);
			P2.setPrix(pd2.getPrice()*P2.getQuantite());
			P2.setProduitID(pd2.getId());
			C1.getProduitcoms().add(P2);

			P2.setCommand(C1);
			double prix=P2.getPrix()+P1.getPrix();
			int quan=P2.getQuantite()+P1.getQuantite();
			C1.setTotale(prix*quan);
			commandRepository.save(C1);

		};
	}
}
