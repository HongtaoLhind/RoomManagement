package de.dlh.lhind.exercise.roommgmt.repository;

import de.dlh.lhind.exercise.roommgmt.model.Building;
import de.dlh.lhind.exercise.roommgmt.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("from Room r where r.building.buildingNumber = (:buildingNumber) and r.roomNumber = (:roomNumber)")
    Optional<Room> findByBuildingNumberAndRoomNumber(@Param("buildingNumber") String buildingNumber, @Param("roomNumber") String roomNumber);

    List<Room> findAllByBuilding(Building building);

    @Query("from Room r where r.building.publicAccess = true")
    List<Room> findAllWithPublicAccess();
}
