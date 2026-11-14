package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agences")
@Tag(name = "gestion dagences",description = "crud")

public class AgenceController {
    private final IAgenceService agenceService;
    @Operation(summary = "ajouter une agence")
    @GetMapping("/affichertoutesagences")
    public List<Agence> getAllAgences() {
        return agenceService.getAgences();
    }

    @PostMapping("ajouterAgence")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping("modifierAgence")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }

    @DeleteMapping("/supprimerAgence/{idAgence}")
    public void deleteAgence(@PathVariable("idAgence") Long idAgence) {
         agenceService.deleteAgence(idAgence);
    }

    @GetMapping("/afficherAgence/{idAgence}")
    public Agence afficherAgence(@PathVariable("idAgence") Long idAgence) {
        return agenceService.getAgenceById(idAgence);
    }

    @PostMapping("/ajouterAgenceEtAffecterVehicules")
    public Agence ajouterAgenceEtAffecterVehicules(@RequestBody Agence agence) {
        return agenceService.ajouterAgenceEtAffecterVehicules(agence);
    }
}
