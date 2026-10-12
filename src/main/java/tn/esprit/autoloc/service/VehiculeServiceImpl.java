package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;

    public Vehicule getVehiculeById(Long id) { return vehiculeRepository.findById(id).orElse(null); }
    public Vehicule addVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public Vehicule updateVehicule(Vehicule vehicule) { return vehiculeRepository.save(vehicule); }
    public void deleteVehicule(Long id) { vehiculeRepository.deleteById(id); }
    public List<Vehicule> getAllVehicules() { return vehiculeRepository.findAll(); }
}
