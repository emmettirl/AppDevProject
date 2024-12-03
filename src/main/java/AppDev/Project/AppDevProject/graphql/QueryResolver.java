package AppDev.Project.AppDevProject.graphql;





import AppDev.Project.AppDevProject.exception.ResourceNotFoundException;
import AppDev.Project.AppDevProject.model.Household;
import AppDev.Project.AppDevProject.model.Pet;
import AppDev.Project.AppDevProject.service.HouseholdService;
import AppDev.Project.AppDevProject.service.PetService;
import AppDev.Project.AppDevProject.service.PetStatistics;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryResolver {

    private final HouseholdService householdService;
    private final PetService petService;

    public QueryResolver(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    @QueryMapping
    public List<Household> getAllHouseholds() {
        return householdService.readAllHouseholds();
    }

    @QueryMapping
    public List<Pet> getPetsByAnimalType(String animalType) {
        return petService.findPetsByAnimalType(animalType);
    }

    @QueryMapping
    public Household getHousehold(String eircode) {
        return householdService.readHouseholdById(eircode)
                .orElseThrow(() -> new ResourceNotFoundException("Household not found with eircode: " + eircode));
    }

    @QueryMapping
    public Pet getPet(String id) {
        return petService.readPetById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
    }

    @QueryMapping
    public PetStatistics getPetStatistics() {
        return new PetStatistics(petService.getAverageAge(), petService.getOldestAge());
    }
}


