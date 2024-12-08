package AppDev.Project.AppDevProject.services;

import AppDev.Project.AppDevProject.entities.Pet;
import AppDev.Project.AppDevProject.exceptions.PetNotFoundException;
import AppDev.Project.AppDevProject.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> readAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet readPetById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new PetNotFoundException("Pet not found with id: " + id));
    }

    @Override
    public Pet updatePet(Long id, Pet petDetails) {
        Pet pet = readPetById(id);
        pet.setName(petDetails.getName());
        pet.setAnimalType(petDetails.getAnimalType());
        pet.setBreed(petDetails.getBreed());
        pet.setAge(petDetails.getAge());
        return petRepository.save(pet);
    }

    @Override
    public void deletePetById(Long id) {
        Pet pet = readPetById(id);
        petRepository.delete(pet);
    }

    @Override
    public void deletePetsByName(String name) {
        List<Pet> pets = petRepository.findAll().stream()
                .filter(pet -> pet.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        petRepository.deleteAll(pets);
    }

    @Override
    public List<Pet> findPetsByAnimalType(String animalType) {
        return petRepository.findAll().stream()
                .filter(pet -> pet.getAnimalType().equalsIgnoreCase(animalType))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pet> findPetsByBreed(String breed) {
        return petRepository.findAll().stream()
                .filter(pet -> pet.getBreed().equalsIgnoreCase(breed))
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pet> getNameAndBreed() {
        return petRepository.findAll().stream()
                .map(pet -> new Pet(pet.getName(), pet.getAnimalType(), pet.getBreed()))
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageAge() {
        return petRepository.findAll().stream()
                .mapToInt(Pet::getAge)
                .average()
                .orElse(0);
    }

    @Override
    public int getOldestAge() {
        return petRepository.findAll().stream()
                .mapToInt(Pet::getAge)
                .max()
                .orElse(0);
    }
}