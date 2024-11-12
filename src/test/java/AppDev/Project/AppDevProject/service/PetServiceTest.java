package AppDev.Project.AppDevProject.service;


import AppDev.Project.AppDevProject.model.Pet;
import AppDev.Project.AppDevProject.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class PetServiceTest {
    private final PetRepository petRepository = Mockito.mock(PetRepository.class);
    private final PetService petService = new PetService(petRepository);

    @Test
    void shouldReturnAllPets() {
        given(petRepository.findAll()).willReturn(List.of(new Pet(null, "Buddy", "Dog", null)));

        List<Pet> pets = petService.findAll();

        assertThat(pets).hasSize(1);
        assertThat(pets.get(0).getName()).isEqualTo("Buddy");
    }
}

