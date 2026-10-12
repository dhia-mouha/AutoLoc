package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {
    private final MaintenanceRepository maintenanceRepository;

    public Maintenance addMaintenance(Maintenance maintenance) { return maintenanceRepository.save(maintenance); }
    public Maintenance updateMaintenance(Maintenance maintenance) { return maintenanceRepository.save(maintenance); }
    public void deleteMaintenance(Long id) { maintenanceRepository.deleteById(id); }
    public Maintenance getMaintenanceById(Long id) { return maintenanceRepository.findById(id).orElse(null); }
    public List<Maintenance> getAllMaintenances() { return maintenanceRepository.findAll(); }
}
