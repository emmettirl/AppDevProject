package AppDev.Project.AppDevProject.service;


import AppDev.Project.AppDevProject.model.Household;
import AppDev.Project.AppDevProject.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    @Autowired
    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    public List<Household> readAllHouseholds() {
        return householdRepository.findAll();
    }

    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findByPetsIsNull();
    }

    public Optional<Household> readHouseholdById(String eircode) {
        return householdRepository.findById(eircode);
    }

    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    public void deleteHouseholdById(String eircode) {
        householdRepository.deleteById(eircode);
    }
}
