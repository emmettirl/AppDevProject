package AppDev.Project.AppDevProject.controller;


import AppDev.Project.AppDevProject.model.Pet;
import AppDev.Project.AppDevProject.service.PetService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.readAllPets();
    }

    @GetMapping("/{id}")
    public Optional<Pet> getPet(@PathVariable Long id) {
        return petService.readPetById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Pet createPet(@RequestBody Pet pet) {
        return petService.createPet(pet);
    }

    @PatchMapping("/{id}/name")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Pet changePetName(@PathVariable Long id, @RequestParam String name) {
        return petService.changePetName(id, name);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
    }
}

