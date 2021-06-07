package de.dlh.lhind.exercise.roommgmt.serviceTests;

import de.dlh.lhind.exercise.roommgmt.model.Building;
import de.dlh.lhind.exercise.roommgmt.repository.BuildingRepository;
import de.dlh.lhind.exercise.roommgmt.service.BuildingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BuildingServiceTest {

    @Mock
    private BuildingRepository mockedBuildingRepository;

    private BuildingService buildingService;

    @BeforeEach
    public void setUp(){
        buildingService = new BuildingService(mockedBuildingRepository);
    }

    @Test
    public void whenFindAll_shouldCallRepository(){
        when(mockedBuildingRepository.findAll()).thenReturn(List.of(
                new Building(-1L, "1a", "test", true)
        ));

        var result = buildingService.findAll();

        assertThat(result).hasSize(1);
        verify(mockedBuildingRepository).findAll();
    }

    @Test
    public void whenFindById_shouldCallRepository(){
        Building testBuilding = new Building(-1L, "1a", "test", true);
        when(mockedBuildingRepository.findById(-1L)).thenReturn(Optional.of(
                testBuilding
        ));

        var result = buildingService.findById(-1L);

        assertThat(result.get()).isEqualTo(testBuilding);
        verify(mockedBuildingRepository).findById(-1L);
    }

    @Test
    public void whenSave_shouldCallRepository(){
        Building testBuilding = new Building(-1L, "1a", "test", true);
        when(mockedBuildingRepository.save(testBuilding)).thenReturn(testBuilding);

        var result = buildingService.save(testBuilding);

        assertThat(result).isEqualTo(testBuilding);
        verify(mockedBuildingRepository).save(testBuilding);
    }

    @Test
    public void whenDelete_shouldCallRepository(){
        Building testBuilding = new Building(-1L, "1a", "test", true);

        buildingService.delete(testBuilding);

        verify(mockedBuildingRepository).delete(testBuilding);
    }

    @Test
    public void whenFindByBuildingNumber_shouldCallRepository(){
        Building testBuilding = new Building(-1L, "1a", "test", true);
        when(mockedBuildingRepository.findByBuildingNumber("1a")).thenReturn(Optional.of(testBuilding));

        var result = buildingService.findByBuildingNumber("1a");

        assertThat(result.get()).isEqualTo(testBuilding);
        verify(mockedBuildingRepository).findByBuildingNumber("1a");
    }

    @Test
    public void whenFindByPublicAccess_shouldCallRepository(){
        Building testBuilding = new Building(-1L, "1a", "test", true);
        when(mockedBuildingRepository.findByPublicAccess(true)).thenReturn(List.of(testBuilding));

        var result = buildingService.findByPublicAccess(true);

        assertThat(result).hasSize(1);
        verify(mockedBuildingRepository).findByPublicAccess(true);
    }
}
