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
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipements")
public class EquipementController {
    private final IEquipementService equipementService;

    @GetMapping("/afficherTousEquipements")
    public List<Equipement> getAllEquipements() {
        return equipementService.getAllEquipement();
    }

    @PostMapping("/ajouterEquipement")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @PutMapping("/modifierEquipement")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.updateEquipement(equipement);
    }

    @DeleteMapping("/supprimerEquipement/{idEquipement}")
    public void supprimerEquipement(@PathVariable("idEquipement") Long idEquipement) {
        equipementService.deleteEquipement(idEquipement);
    }

    @GetMapping("/afficherEquipement/{idEquipement}")
    public Equipement afficherEquipement(@PathVariable("idEquipement") Long idEquipement) {
        return equipementService.getEquipement(idEquipement);
    }
}
