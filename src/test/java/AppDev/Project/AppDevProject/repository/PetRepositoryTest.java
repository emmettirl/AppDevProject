package AppDev.Project.AppDevProject.repository;

import AppDev.Project.AppDevProject.model.Household;
import AppDev.Project.AppDevProject.model.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PetRepositoryTest {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private HouseholdRepository householdRepository;

    @Test
    void shouldSavePet() {
        Household household = new Household(null, "123 Main St", null);
        household = householdRepository.save(household);

        Pet pet = new Pet(null, "Buddy", "Dog", household);
        pet = petRepository.save(pet);

        assertThat(pet).isNotNull();
        assertThat(pet.getId()).isNotNull();
    }
}
