package de.dlh.lhind.exercise.roommgmt.controllerTests;

import de.dlh.lhind.exercise.roommgmt.controller.BuildingController;
import de.dlh.lhind.exercise.roommgmt.model.Building;
import de.dlh.lhind.exercise.roommgmt.service.BuildingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = BuildingController.class)
public class BuildingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuildingService mockedBuildingService;

    @Test
    public void whenFindAll_shouldReturnBuildingList() throws Exception{
        when(mockedBuildingService.findAll()).thenReturn(List.of(
               new Building(-1L, "1a", "test", true)
        ));

        mockMvc.perform(get("/buildings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(-1))
                .andExpect(jsonPath("$[0].buildingNumber").value("1a"))
                .andExpect(jsonPath("$[0].description").value("test"))
                .andExpect(jsonPath("$[0].publicAccess").value(true));
    }

    @Test
    public void whenFindByBuildingNumber_shouldReturnBuilding() throws Exception{
        when(mockedBuildingService.findByBuildingNumber("1a")).thenReturn(
                Optional.of(new Building(-1L, "1a", "test", true))
        );

        mockMvc.perform(get("/buildings/building_number/1a"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(-1))
                .andExpect(jsonPath("buildingNumber").value("1a"))
                .andExpect(jsonPath("description").value("test"))
                .andExpect(jsonPath("publicAccess").value(true));
    }

    @Test
    public void whenFindByPublicAccess_shouldReturnBuildingList() throws Exception{
        when(mockedBuildingService.findByPublicAccess(true)).thenReturn(List.of(
                new Building(-1L, "1a", "test", true)
        ));

        mockMvc.perform(get("/buildings/public"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(-1))
                .andExpect(jsonPath("$[0].buildingNumber").value("1a"))
                .andExpect(jsonPath("$[0].description").value("test"))
                .andExpect(jsonPath("$[0].publicAccess").value(true));
    }
}
