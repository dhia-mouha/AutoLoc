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
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiements")
public class PaiementController {
    private final IPaiementService paiementService;

    @GetMapping("/afficherTousPaiements")
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.updatePaiement(paiement);
    }

    @DeleteMapping("/supprimerPaiement/{idPaiement}")
    public void supprimerPaiement(@PathVariable("idPaiement") Long idPaiement) {
        paiementService.deletePaiement(idPaiement);
    }

    @GetMapping("/afficherPaiement/{idPaiement}")
    public Paiement afficherPaiement(@PathVariable("idPaiement") Long idPaiement) {
        return paiementService.getPaiementById(idPaiement);
    }
}
