package AppDev.Project.AppDevProject.controller;



import AppDev.Project.AppDevProject.model.Pet;
import AppDev.Project.AppDevProject.service.PetService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.findAll();
    }

    @PostMapping
    public Pet createPet(@Valid @RequestBody Pet pet) {
        return petService.save(pet);
    }
}

