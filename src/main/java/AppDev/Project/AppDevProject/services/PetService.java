package AppDev.Project.AppDevProject.services;

import AppDev.Project.AppDevProject.entities.Pet;

import java.util.List;

public interface PetService {
    Pet createPet(Pet pet);
    List<Pet> readAllPets();
    Pet readPetById(Long id);
    Pet updatePet(Long id, Pet petDetails);
    void deletePetById(Long id);
    void deletePetsByName(String name);
    List<Pet> findPetsByAnimalType(String animalType);
    List<Pet> findPetsByBreed(String breed);
    List<Pet> getNameAndBreed();
    double getAverageAge();
    int getOldestAge();
}