package AppDev.Project.AppDevProject.graphql;

import AppDev.Project.AppDevProject.entities.Household;
import AppDev.Project.AppDevProject.entities.Pet;
import AppDev.Project.AppDevProject.services.HouseholdService;
import AppDev.Project.AppDevProject.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

@Controller
public class QueryController implements GraphQLQueryResolver {

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private PetService petService;

    @QueryMapping
    public List<Household> getAllHouseholds() {
        return householdService.readAllHouseholds();
    }

    @QueryMapping
    public List<Pet> getAllPetsByAnimalType(String animalType) {
        return petService.findPetsByAnimalType(animalType);
    }

    @QueryMapping
    public Household getHousehold(String eircode) {
        return householdService.readHouseholdById(eircode);
    }

    @QueryMapping
    public Pet getPet(Long id) {
        return petService.readPetById(id);
    }

    @QueryMapping
    public PetStatistics getPetStatistics() {
        double averageAge = petService.getAverageAge();
        int oldestAge = petService.getOldestAge();
        return new PetStatistics(averageAge, oldestAge);
    }
}