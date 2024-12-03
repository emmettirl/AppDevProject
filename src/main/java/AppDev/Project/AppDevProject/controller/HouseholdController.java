package AppDev.Project.AppDevProject.controller;


import AppDev.Project.AppDevProject.model.Household;
import AppDev.Project.AppDevProject.service.HouseholdService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/households")
public class HouseholdController {
    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.readAllHouseholds();
    }

    @GetMapping("/noPets")
    public List<Household> getHouseholdsWithNoPets() {
        return householdService.findHouseholdsWithNoPets();
    }

    @GetMapping("/{eircode}")
    public Optional<Household> getHousehold(@PathVariable String eircode) {
        return householdService.readHouseholdById(eircode);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Household createHousehold(@RequestBody Household household) {
        return householdService.createHousehold(household);
    }

    @DeleteMapping("/{eircode}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHouseholdById(eircode);
    }
}

