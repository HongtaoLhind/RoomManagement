package de.dlh.lhind.exercise.roommgmt.repository;

import de.dlh.lhind.exercise.roommgmt.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    Optional<Building> findByBuildingNumber(String buildingNumber);

    @Query("from Building b where b.publicAccess = (:publicAccess)")
    List<Building> findByPublicAccess(@Param("publicAccess") Boolean publicAccess);
}
