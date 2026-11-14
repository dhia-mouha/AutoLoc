package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
    private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;

    public Agence addAgence(Agence agence) { return agenceRepository.save(agence); }
    public Agence updateAgence(Agence agence) { return agenceRepository.save(agence); }
    public Agence getAgenceById(Long id) { return agenceRepository.findById(id).orElse(null); }
    public List<Agence> getAgences() { return agenceRepository.findAll(); }
    public void deleteAgence(Long id) { agenceRepository.deleteById(id); }

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        if (agence == null || agence.getIdAgence() != null
                || agence.getVehicules() == null || agence.getVehicules().size() != 2) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Une nouvelle agence doit contenir exactement deux vehicules");
        }

        List<Vehicule> vehicules = new ArrayList<>(agence.getVehicules());
        if (vehicules.get(0) == vehicules.get(1)
                || vehicules.stream().anyMatch(vehicule -> !isVehiculeValide(vehicule))) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Les deux vehicules doivent etre nouveaux et contenir les champs requis");
        }

        agence.setVehicules(new ArrayList<>());
        Agence agenceEnregistree = agenceRepository.save(agence);
        for (Vehicule vehicule : vehicules) {
            vehicule.setAgence(agenceEnregistree);
            agenceEnregistree.getVehicules().add(vehicule);
            vehiculeRepository.save(vehicule);
        }
        return agenceEnregistree;
    }

    private boolean isVehiculeValide(Vehicule vehicule) {
        return vehicule != null
                && vehicule.getIdVehicule() == null
                && vehicule.getMarque() != null && !vehicule.getMarque().isBlank()
                && vehicule.getModele() != null && !vehicule.getModele().isBlank()
                && vehicule.getCategorie() != null
                && vehicule.getTarifJournalier() != null
                && vehicule.getStatut() != null;
    }
}
