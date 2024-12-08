package AppDev.Project.AppDevProject.controllers;

import AppDev.Project.AppDevProject.dtos.PetDTO;
import AppDev.Project.AppDevProject.entities.Pet;
import AppDev.Project.AppDevProject.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.readAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPet(@PathVariable Long id) {
        return petService.readPetById(id);
    }

    @PostMapping
    public Pet createPet(@Valid @RequestBody PetDTO petDTO) {
        Pet pet = new Pet(petDTO.name(), petDTO.animalType(), petDTO.breed());
        pet.setAge(petDTO.age());
        // Set household based on householdEircode
        return petService.createPet(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/name")
    public Pet changePetName(@PathVariable Long id, @RequestBody String newName) {
        Pet pet = petService.readPetById(id);
        pet.setName(newName);
        return petService.updatePet(id, pet);
    }
}