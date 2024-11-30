package AppDev.Project.AppDevProject.repository;

import AppDev.Project.AppDevProject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByAnimalType(String animalType);
    List<Pet> findByBreedOrderByAgeAsc(String breed);
    List<Pet> findByHouseholdIsNotNull();
    List<Pet> findByHouseholdIsNull();
    List<Pet> findByNameIgnoreCase(String name);
}
