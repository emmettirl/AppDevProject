package AppDev.Project.AppDevProject.controller;


import AppDev.Project.AppDevProject.model.Pet;
import AppDev.Project.AppDevProject.service.PetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;

@WebMvcTest(PetController.class)
class PetControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetService petService;

    @Test
    void shouldReturnAllPets() throws Exception {
        given(petService.findAll()).willReturn(List.of(new Pet(1L, "Buddy", "Dog", null)));

        mockMvc.perform(get("/pets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Buddy"));
    }

    @Test
    void shouldCreatePet() throws Exception {
        Pet pet = new Pet(1L, "Buddy", "Dog", null);
        given(petService.save(Mockito.any(Pet.class))).willReturn(pet);

        mockMvc.perform(post("/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Buddy\",\"species\":\"Dog\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Buddy"));
    }
}

