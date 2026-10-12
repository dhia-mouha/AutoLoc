package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import java.util.List;

public interface IEquipementService {
    Equipement addEquipement(Equipement equipement);
    Equipement updateEquipement(Equipement equipement);
    Equipement getEquipement(Long id);
    List<Equipement> getAllEquipement();
    void deleteEquipement(Long id);
}
