package de.dlh.lhind.exercise.roommgmt.service;

import de.dlh.lhind.exercise.roommgmt.model.Building;
import de.dlh.lhind.exercise.roommgmt.model.Room;
import de.dlh.lhind.exercise.roommgmt.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public Optional<Room> findById(Long id){
        return roomRepository.findById(id);
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public void delete(Room room) {
        roomRepository.delete(room);
    }

    public Optional<Room> findByBuildingNumberAndRoomNumber(String buildingNumber, String roomNumber){
        return roomRepository.findByBuildingNumberAndRoomNumber(buildingNumber, roomNumber);
    }

    public List<Room> findAllByBuilding(Building building){
        return roomRepository.findAllByBuilding(building);
    }

    public List<Room> findAllWithPublicAccess(){
        return roomRepository.findAllWithPublicAccess();
    }
}
