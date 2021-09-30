package com.example.gestioncomptes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Collections;


@SpringBootApplication
public class GestioncomptesApplication {

	private static final Logger log = LoggerFactory.getLogger(GestioncomptesApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(GestioncomptesApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(ClientRepository clientRepository,
								  RepositoryRestConfiguration repositoryRestConfiguration) {
		return (args) -> {
			repositoryRestConfiguration.exposeIdsFor(Client.class);
			Client client= new Client("Ngom","Seune");
			client.setAdresse("Pontault Combault 77340");
			client.setEmail("seunengom@gmail.com");
			client.setTel("0753406319");
			client.setMdp("Seune96");

			Client client1= new Client("Sall","Fara");
			client1.setAdresse("Pontault Combault 77340");
			client1.setEmail("farasall@gmail.com");
			client1.setTel("0753406319");
			client1.setMdp("Sall96");

			clientRepository.save(client);
			clientRepository.save(client1);



		};
	}

}
