package AppDev.Project.AppDevProject.controllers;

import AppDev.Project.AppDevProject.dtos.HouseholdDTO;
import AppDev.Project.AppDevProject.entities.Household;
import AppDev.Project.AppDevProject.services.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/households")
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.readAllHouseholds();
    }

    @GetMapping("/no-pets")
    public List<Household> getHouseholdsWithNoPets() {
        return householdService.findHouseholdsWithNoPets();
    }

    @GetMapping("/{eircode}")
    public Household getHousehold(@PathVariable String eircode) {
        return householdService.readHouseholdById(eircode);
    }

    @PostMapping
    public Household createHousehold(@Valid @RequestBody HouseholdDTO householdDTO) {
        Household household = new Household();
        household.setEircode(householdDTO.eircode());
        household.setNumberOccupants(householdDTO.numberOccupants());
        household.setMaxNumberOccupants(householdDTO.maxNumberOccupants());
        household.setOwnerOccupied(householdDTO.ownerOccupied());
        return householdService.createHousehold(household);
    }

    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHouseholdById(eircode);
        return ResponseEntity.noContent().build();
    }
}