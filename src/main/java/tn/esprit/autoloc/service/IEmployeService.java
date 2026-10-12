package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import java.util.List;

public interface IEmployeService {
    Employe addEmploye(Employe employe);
    Employe updateEmploye(Employe employe);
    Employe getEmpById(Long id);
    List<Employe> getEmployes();
    void deleteEmploye(Long id);
}
