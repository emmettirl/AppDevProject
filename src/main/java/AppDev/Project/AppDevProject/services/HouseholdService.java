package AppDev.Project.AppDevProject.services;

import AppDev.Project.AppDevProject.entities.Household;

import java.util.List;

public interface HouseholdService {
    Household createHousehold(Household household);
    List<Household> readAllHouseholds();
    Household readHouseholdById(String eircode);
    Household readHouseholdByIdWithPets(String eircode);
    Household updateHousehold(String eircode, Household householdDetails);
    void deleteHouseholdById(String eircode);
    List<Household> findHouseholdsWithNoPets();
    List<Household> findHouseholdsByOwnerOccupied(boolean ownerOccupied);
    long getNumberOfEmptyHouses();
    long getNumberOfFullHouses();
}