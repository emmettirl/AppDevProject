package AppDev.Project.AppDevProject.graphql;



import AppDev.Project.AppDevProject.model.Household;
import AppDev.Project.AppDevProject.service.HouseholdService;
import AppDev.Project.AppDevProject.service.PetService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {

    private final HouseholdService householdService;
    private final PetService petService;

    public MutationResolver(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    @MutationMapping
    public Household createHousehold(HouseholdInput householdInput) {
        Household household = new Household(
                householdInput.getEircode(),
                householdInput.getNumberOccupants(),
                householdInput.getMaxOccupants(),
                householdInput.isOwnerOccupied(),
                null
        );
        return householdService.createHousehold(household);
    }

    @MutationMapping
    public String deleteHousehold(String eircode) {
        householdService.deleteHouseholdById(eircode);
        return "Household deleted successfully";
    }

    @MutationMapping
    public String deletePet(String id) {
        petService.deletePetById(Long.parseLong(id));
        return "Pet deleted successfully";
    }
}
