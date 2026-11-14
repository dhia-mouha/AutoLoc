package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    public Vehicule getVehiculeById(Long id) { return vehiculeRepository.findById(id).orElse(null); }
    public Vehicule addVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public Vehicule updateVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public void deleteVehicule(Long id) { vehiculeRepository.deleteById(id); }
    public List<Vehicule> getAllVehicules() { return vehiculeRepository.findAll(); }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = findVehicule(idVehicule);
        Equipement equipement = findEquipement(idEquipement);

        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);
        }
        if (!equipement.getVehicules().contains(vehicule)) {
            equipement.getVehicules().add(vehicule);
        }
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = findVehicule(idVehicule);
        Equipement equipement = findEquipement(idEquipement);

        vehicule.getEquipements().remove(equipement);
        equipement.getVehicules().remove(vehicule);
        return vehiculeRepository.save(vehicule);
    }

    private Vehicule findVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicule introuvable"));
    }

    private Equipement findEquipement(Long idEquipement) {
        return equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipement introuvable"));
    }
}
