package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {
    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    public Employe addEmploye(Employe employe) { return employeRepository.save(employe); }
    public Employe updateEmploye(Employe employe) { return employeRepository.save(employe); }
    public Employe getEmpById(Long id) { return employeRepository.findById(id).orElse(null); }
    public List<Employe> getEmployes() { return employeRepository.findAll(); }
    public void deleteEmploye(Long id) { employeRepository.deleteById(id); }

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employe introuvable"));
        employe.setAgence(null);
        return employeRepository.save(employe);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employe introuvable"));
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agence introuvable"));
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }
}
