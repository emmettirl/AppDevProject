package AppDev.Project.AppDevProject.controller;


import AppDev.Project.AppDevProject.model.Household;
import AppDev.Project.AppDevProject.service.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/households")
public class HouseholdController {
    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.findAll();
    }

    @PostMapping
    public Household createHousehold(@Valid @RequestBody Household household) {
        return householdService.save(household);
    }
}
