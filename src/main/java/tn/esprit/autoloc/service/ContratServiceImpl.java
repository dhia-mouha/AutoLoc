package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {
    private final ContratRepository contratRepository;

    public Contrat ajouterContrat(Contrat contrat) { return contratRepository.save(contrat); }
    public Contrat modifierContrat(Contrat contrat) { return contratRepository.save(contrat); }
    public Contrat afficherContratById(Long id) { return contratRepository.findById(id).orElse(null); }
    public List<Contrat> listerContrats() { return contratRepository.findAll(); }
    public void supprimerContrat(Long id) { contratRepository.deleteById(id); }
}
