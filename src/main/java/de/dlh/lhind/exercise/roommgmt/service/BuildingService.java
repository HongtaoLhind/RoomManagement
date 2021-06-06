package de.dlh.lhind.exercise.roommgmt.service;

import de.dlh.lhind.exercise.roommgmt.model.Building;
import de.dlh.lhind.exercise.roommgmt.repository.BuildingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BuildingService {
    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository){
        this.buildingRepository = buildingRepository;
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    public Optional<Building> findById(Long id){
        return buildingRepository.findById(id);
    }

    public Building save(Building building) {
        return buildingRepository.save(building);
    }

    public void delete(Building building) {
        buildingRepository.delete(building);
    }

    public Optional<Building> findByBuildingNumber(String buildingNumber){
        return buildingRepository.findByBuildingNumber(buildingNumber);
    }

    public List<Building> findByPublicAccess(Boolean publicAccess){
        return buildingRepository.findByPublicAccess(publicAccess);
    }
}
