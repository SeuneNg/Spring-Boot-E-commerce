package com.example.GestionCommande;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RestController
public class RestCommnade {
    private static final Logger log = LoggerFactory.getLogger(RestCommnade.class);

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Error")
    @ExceptionHandler(Exception.class)
    public void error() {
    }
    private List<Produitcom> produitcoms=new ArrayList<Produitcom>();
    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private ProduitcomRepository produitcomRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProduitService produitService;

    @GetMapping("/fullcommands/{id}")
    public Command getCommand(@PathVariable(name = "id") Long id){
        Command command=commandRepository.findById(id).get();
        command.setClient(clientService.findClientById(command.getClientID()));
        return command;
    }
    @GetMapping(value = "/commandes")
    public List<Command> getCommande(){
        return commandRepository.findAll();
    }

    @PostMapping(value = "/ajoutcomm")
    public void addCommande(@RequestBody Command command) throws Exception {
       commandRepository.save(command);
    }

    @PostMapping("/commandes")
    public Command saveCommande(@RequestBody OrderForm orderForm){
        Client client=new Client();
        client.setNom(orderForm.getClient().getNom());
        client.setPrenom(orderForm.getClient().getPrenom());
        client.setAdresse(orderForm.getClient().getAdresse());
        client.setEmail(orderForm.getClient().getEmail());
        client.setMdp(orderForm.getClient().getMdp());
        client.setTel(orderForm.getClient().getTel());

        Command command=new Command();
        command.setClient(client);
        command.setDatecom(new Date());
        command=commandRepository.save(command);
        double total=0;
        for(OrderProduct p:orderForm.getProduits()){
            Produitcom produitcom=new Produitcom();
            produitcom.setCommand(command);
            produitcom=produitcomRepository.findById(p.getId()).get();
            produitcom=produitcomRepository.save(produitcom);
            total+=p.getQuantite()*produitcom.getPrix();
        }
        command.setTotale(total);
        return commandRepository.save(command);

    }
}
