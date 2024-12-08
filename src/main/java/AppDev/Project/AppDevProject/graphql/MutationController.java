package AppDev.Project.AppDevProject.graphql;

import AppDev.Project.AppDevProject.entities.Household;
import AppDev.Project.AppDevProject.services.HouseholdService;
import AppDev.Project.AppDevProject.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Controller
public class MutationController implements GraphQLMutationResolver {

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private PetService petService;

    @MutationMapping
    public Household createHousehold(HouseholdInput input) {
        Household household = new Household();
        household.setEircode(input.eircode());
        household.setNumberOccupants(input.numberOccupants());
        household.setMaxNumberOccupants(input.maxNumberOccupants());
        household.setOwnerOccupied(input.ownerOccupied());
        return householdService.createHousehold(household);
    }

    @MutationMapping
    public boolean deleteHousehold(String eircode) {
        householdService.deleteHouseholdById(eircode);
        return true;
    }

    @MutationMapping
    public boolean deletePet(Long id) {
        petService.deletePetById(id);
        return true;
    }
}