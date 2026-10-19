package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final IClientService clientService;

    @GetMapping("/afficherTousClients")
    public List<Client> afficherAllClients() {
        return clientService.afficherAllClients();
    }

    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @DeleteMapping("/supprimerClient/{idClient}")
    public Client supprimerClient(@PathVariable("idClient") Long idClient) {
        return clientService.supprimerClient(idClient);
    }

    @GetMapping("/afficherClient/{idClient}")
    public Client afficherClient(@PathVariable("idClient") Long idClient) {
        return clientService.afficherClientById(idClient);
    }
}
