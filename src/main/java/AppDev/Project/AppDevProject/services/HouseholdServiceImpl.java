package AppDev.Project.AppDevProject.services;

import AppDev.Project.AppDevProject.entities.Household;
import AppDev.Project.AppDevProject.exceptions.HouseholdNotFoundException;
import AppDev.Project.AppDevProject.repositories.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    @Autowired
    private HouseholdRepository householdRepository;

    @Override
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    @Override
    public List<Household> readAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Household readHouseholdById(String eircode) {
        return householdRepository.findById(eircode)
                .orElseThrow(() -> new HouseholdNotFoundException("Household not found with eircode: " + eircode));
    }

    @Override
    public Household readHouseholdByIdWithPets(String eircode) {
        Household household = readHouseholdById(eircode);
        household.getPets().size(); // Trigger lazy loading
        return household;
    }

    @Override
    public Household updateHousehold(String eircode, Household householdDetails) {
        Household household = readHouseholdById(eircode);
        household.setNumberOccupants(householdDetails.getNumberOccupants());
        household.setMaxNumberOccupants(householdDetails.getMaxNumberOccupants());
        household.setOwnerOccupied(householdDetails.isOwnerOccupied());
        return householdRepository.save(household);
    }

    @Override
    public void deleteHouseholdById(String eircode) {
        Household household = readHouseholdById(eircode);
        householdRepository.delete(household);
    }

    @Override
    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findByPetsIsNull();
    }

    @Override
    public List<Household> findHouseholdsByOwnerOccupied(boolean ownerOccupied) {
        return householdRepository.findByOwnerOccupied(ownerOccupied);
    }

    @Override
    public long getNumberOfEmptyHouses() {
        return householdRepository.findAll().stream()
                .filter(household -> household.getNumberOccupants() == 0)
                .count();
    }

    @Override
    public long getNumberOfFullHouses() {
        return householdRepository.findAll().stream()
                .filter(household -> household.getNumberOccupants() == household.getMaxNumberOccupants())
                .count();
    }
}