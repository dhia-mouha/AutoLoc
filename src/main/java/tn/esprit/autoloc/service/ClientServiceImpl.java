package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {
    private final ClientRepository clientRepository;

    public Client ajouterClient(Client client) { return clientRepository.save(client); }
    public Client modifierClient(Client client) { return clientRepository.save(client); }
    public Client afficherClientById(Long id) { return clientRepository.findById(id).orElse(null); }
    public List<Client> afficherAllClients() { return clientRepository.findAll(); }
    public Client supprimerClient(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) clientRepository.delete(client);
        return client;
    }
}
