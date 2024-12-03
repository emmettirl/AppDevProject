package AppDev.Project.AppDevProject.service;



import AppDev.Project.AppDevProject.exception.ResourceNotFoundException;
import AppDev.Project.AppDevProject.model.Pet;
import AppDev.Project.AppDevProject.repository.PetRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> readAllPets() {
        return petRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Optional<Pet> readPetById(Long id) {
        return Optional.ofNullable(petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id)));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePetById(Long id) {
        if (!petRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pet not found with id: " + id);
        }
        petRepository.deleteById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Pet changePetName(Long id, String name) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
        pet.setName(name);
        return petRepository.save(pet);
    }

    public List<Pet> findPetsByAnimalType(String animalType) {
        return petRepository.findByAnimalType(animalType);
    }

    public double getAverageAge() {
        return petRepository.findAll().stream().mapToInt(Pet::getAge).average().orElse(0.0);
    }

    public int getOldestAge() {
        return petRepository.findAll().stream().mapToInt(Pet::getAge).max().orElse(0);
    }
}

