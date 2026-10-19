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
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrats")
public class ContratController {
    private final IContratService contratService;

    @GetMapping("/afficherTousContrats")
    public List<Contrat> listerContrats() {
        return contratService.listerContrats();
    }

    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @PutMapping("/modifierContrat")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @DeleteMapping("/supprimerContrat/{idContrat}")
    public void supprimerContrat(@PathVariable("idContrat") Long idContrat) {
        contratService.supprimerContrat(idContrat);
    }

    @GetMapping("/afficherContrat/{idContrat}")
    public Contrat afficherContrat(@PathVariable("idContrat") Long idContrat) {
        return contratService.afficherContratById(idContrat);
    }
}
