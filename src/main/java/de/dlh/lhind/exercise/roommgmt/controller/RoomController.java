package de.dlh.lhind.exercise.roommgmt.controller;

import de.dlh.lhind.exercise.roommgmt.model.Room;
import de.dlh.lhind.exercise.roommgmt.service.BuildingService;
import de.dlh.lhind.exercise.roommgmt.service.RoomService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;
    private final BuildingService buildingService;

    public RoomController(RoomService roomService, BuildingService buildingService){
        this.roomService = roomService;
        this.buildingService = buildingService;
    }

    @GetMapping()
    public List<Room> allRooms(){
        return roomService.findAll();
    }

    @GetMapping("/building_number/{buildingNumber}/room_number/{roomNumber}")
    public Room findByBuildingNumberAndRoomNumber(@PathVariable String buildingNumber, @PathVariable String roomNumber){
        return this.roomService.findByBuildingNumberAndRoomNumber(buildingNumber, roomNumber).get();
    }

    @GetMapping("/building/{id}")
    public List<Room> findAllByBuilding(@PathVariable Long id){
        return this.roomService.findAllByBuilding(buildingService.findById(id).get());
    }

    @GetMapping("/public")
    public List<Room> findByPublicAccess(){
        return roomService.findAllWithPublicAccess();
    }

    @PutMapping("/update")
    public void UpdateRoom(@RequestParam(name = "id") Long id, @RequestParam(name = "buildingId") Long buildingId, @RequestParam(name = "roomNumber") String roomNumber, @RequestParam(name = "seats") Integer seats, @RequestParam(name = "projectorPresent") Boolean projectorPresent){
        this.roomService.save(new Room(id, buildingService.findById(buildingId).get(), roomNumber, seats, projectorPresent));
    }

    @PostMapping("/create")
    public void CreateRoom(@RequestParam(name = "id") Long id, @RequestParam(name = "buildingId") Long buildingId, @RequestParam(name = "roomNumber") String roomNumber, @RequestParam(name = "seats") Integer seats, @RequestParam(name = "projectorPresent") Boolean projectorPresent){
        this.roomService.save(new Room(id, buildingService.findById(buildingId).get(), roomNumber, seats, projectorPresent));
    }

    @DeleteMapping("/delete")
    public void DeleteRoom(@RequestParam(name = "id") Long id){
        Room room = this.roomService.findById(id).get();
        this.roomService.delete(room);
    }
}
