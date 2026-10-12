package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {
    private final EquipementRepository equipementRepository;

    public Equipement addEquipement(Equipement equipement) { return equipementRepository.save(equipement); }
    public Equipement updateEquipement(Equipement equipement) { return equipementRepository.save(equipement); }
    public Equipement getEquipement(Long id) { return equipementRepository.findById(id).orElse(null); }
    public List<Equipement> getAllEquipement() { return equipementRepository.findAll(); }
    public void deleteEquipement(Long id) { equipementRepository.deleteById(id); }
}
