package de.dlh.lhind.exercise.roommgmt.controller;

import de.dlh.lhind.exercise.roommgmt.model.Building;
import de.dlh.lhind.exercise.roommgmt.service.BuildingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService){
        this.buildingService = buildingService;
    }

    @GetMapping()
    public List<Building> allBuildings(){
        return buildingService.findAll();
    }

    @GetMapping("/building_number/{buildingNumber}")
    public Building findByBuildingNumber(@PathVariable String buildingNumber){
        return buildingService.findByBuildingNumber(buildingNumber).get();
    }

    @GetMapping("/public")
    public List<Building> findByPublicAccess(){
        return buildingService.findByPublicAccess(true);
    }

    @PutMapping("/update")
    public void UpdateBuilding(@RequestParam(name = "id") Long id, @RequestParam(name = "buildingNumber") String buildingNumber, @RequestParam(name = "description") String description, @RequestParam(name = "publicAccess") Boolean publicAccess){
        this.buildingService.save(new Building(id, buildingNumber, description, publicAccess));
    }

    @PostMapping("/create")
    public void CreateBuilding(@RequestParam(name = "id") Long id, @RequestParam(name = "buildingNumber") String buildingNumber, @RequestParam(name = "description") String description, @RequestParam(name = "publicAccess") Boolean publicAccess){
        this.buildingService.save(new Building(id, buildingNumber, description, publicAccess));
    }

    @DeleteMapping("/delete")
    public void DeleteBuilding(@RequestParam(name = "id") Long id){
        Building building = this.buildingService.findById(id).get();
        this.buildingService.delete(building);
    }
}
