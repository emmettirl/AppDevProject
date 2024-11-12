package AppDev.Project.AppDevProject.service;



import AppDev.Project.AppDevProject.model.Household;
import AppDev.Project.AppDevProject.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    public List<Household> findAll() {
        return householdRepository.findAll();
    }

    public Household save(Household household) {
        return householdRepository.save(household);
    }
}
