package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
    private final AgenceRepository agenceRepository;

    public Agence addAgence(Agence agence) { return agenceRepository.save(agence); }
    public Agence updateAgence(Agence agence) { return agenceRepository.save(agence); }
    public Agence getAgenceById(Long id) { return agenceRepository.findById(id).orElse(null); }
    public List<Agence> getAgences() { return agenceRepository.findAll(); }
    public void deleteAgence(Long id) { agenceRepository.deleteById(id); }
}
