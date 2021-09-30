package com.example.produits;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProduitsApplication {

	private static final Logger log = LoggerFactory.getLogger(ProduitsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(ProduitRepository produitRepository,
								  RepositoryRestConfiguration repositoryRestConfiguration) {
		return (args) -> {
			//pour afficher les id
			repositoryRestConfiguration.exposeIdsFor(Produit.class);

			Produit produit= new Produit();
			produit.setDesignation("Lenevo Thinkpad");
			produit.setDescription("Ordi portabel Lenevo 5eme generation disk ssd 250");
			produit.setPrice(2400);
			produit.setFilename("lenevo.png");

			Produit produit1= new Produit();
			produit1.setDesignation("Ordi HP 878");
			produit1.setDescription("Ordi portable HP 7eme generation");
			produit1.setPrice(1800);
			produit1.setFilename("hp7eme.png");

			Produit produit2= new Produit();
			produit2.setDesignation("Ordi MAC Air");
			produit2.setDescription(" Ordi portable MAC BOOK AIR 2019");
			produit2.setPrice(2578);
			produit2.setFilename("mackbooair2019.png");

			Produit produit3= new Produit();
			produit3.setDesignation("Imprimante Lazer");
			produit3.setDescription(" imprimante laser fonctionne avec un toner");
			produit3.setPrice(1200);
			produit3.setFilename("imprimantelaser.png");

			Produit produit4= new Produit();
			produit4.setDesignation("Imprimante Lazer HP");
			produit4.setDescription(" imprimante laser fonctionne avec un toner");
			produit4.setPrice(1300);
			produit4.setFilename("imprimantelaserhp.png");

			Produit produit5= new Produit();
			produit5.setDesignation("Ordi DELL Inperon");
			produit5.setDescription(" Ordinateur Dell 7eme generation");
			produit5.setPrice(1700);
			produit5.setFilename("dellordi.png");

			produitRepository.save(produit);
			produitRepository.save(produit1);
			produitRepository.save(produit2);
			produitRepository.save(produit3);
			produitRepository.save(produit4);
			produitRepository.save(produit5);

			produitRepository.findAll().forEach(p->{
				System.out.println(p.toString());
			});


		};
	}

}
