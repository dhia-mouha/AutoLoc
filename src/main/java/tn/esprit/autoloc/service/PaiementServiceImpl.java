package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {
    private final PaiementRepository paiementRepository;

    public Paiement addPaiement(Paiement paiement) { return paiementRepository.save(paiement); }
    public Paiement updatePaiement(Paiement paiement) { return paiementRepository.save(paiement); }
    public void deletePaiement(Long id) { paiementRepository.deleteById(id); }
    public Paiement getPaiementById(Long id) { return paiementRepository.findById(id).orElse(null); }
    public List<Paiement> getAllPaiements() { return paiementRepository.findAll(); }
}
