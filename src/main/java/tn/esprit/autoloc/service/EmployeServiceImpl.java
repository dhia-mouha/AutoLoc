package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {
    private final EmployeRepository employeRepository;

    public Employe addEmploye(Employe employe) { return employeRepository.save(employe); }
    public Employe updateEmploye(Employe employe) { return employeRepository.save(employe); }
    public Employe getEmpById(Long id) { return employeRepository.findById(id).orElse(null); }
    public List<Employe> getEmployes() { return employeRepository.findAll(); }
    public void deleteEmploye(Long id) { employeRepository.deleteById(id); }
}
