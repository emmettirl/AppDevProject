package AppDev.Project.AppDevProject.service;


import AppDev.Project.AppDevProject.model.Pet;
import AppDev.Project.AppDevProject.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> readAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> readPetById(Long id) {
        return petRepository.findById(id);
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    public Pet changePetName(Long id, String name) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
        pet.setName(name);
        return petRepository.save(pet);
    }
}
