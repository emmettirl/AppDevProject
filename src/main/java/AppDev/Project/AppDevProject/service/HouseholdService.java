package AppDev.Project.AppDevProject.service;



import AppDev.Project.AppDevProject.exception.ResourceNotFoundException;
import AppDev.Project.AppDevProject.model.Household;
import AppDev.Project.AppDevProject.repository.HouseholdRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    public List<Household> readAllHouseholds() {
        return householdRepository.findAll();
    }

    public Optional<Household> readHouseholdById(String eircode) {
        return Optional.ofNullable(householdRepository.findById(eircode).orElseThrow(() -> new ResourceNotFoundException("Household not found with eircode: " + eircode)));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Household updateHousehold(String eircode, Household householdDetails) {
        Household household = householdRepository.findById(eircode).orElseThrow(() -> new ResourceNotFoundException("Household not found with eircode: " + eircode));
        household.setNumberOccupants(householdDetails.getNumberOccupants());
        household.setMaxOccupants(householdDetails.getMaxOccupants());
        household.setOwnerOccupied(householdDetails.isOwnerOccupied());
        return householdRepository.save(household);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteHouseholdById(String eircode) {
        if (!householdRepository.existsById(eircode)) {
            throw new ResourceNotFoundException("Household not found with eircode: " + eircode);
        }
        householdRepository.deleteById(eircode);
    }

    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findByPetsIsNull();
    }
}
