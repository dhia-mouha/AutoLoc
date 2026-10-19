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
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicules")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @GetMapping("/afficherTousVehicules")
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @PutMapping("/modifierVehicule")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(vehicule);
    }

    @DeleteMapping("/supprimerVehicule/{idVehicule}")
    public void supprimerVehicule(@PathVariable("idVehicule") Long idVehicule) {
        vehiculeService.deleteVehicule(idVehicule);
    }

    @GetMapping("/afficherVehicule/{idVehicule}")
    public Vehicule afficherVehicule(@PathVariable("idVehicule") Long idVehicule) {
        return vehiculeService.getVehiculeById(idVehicule);
    }
}
