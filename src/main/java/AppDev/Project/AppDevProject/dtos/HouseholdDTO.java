package AppDev.Project.AppDevProject.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record HouseholdDTO(
        @NotBlank String eircode,
        @NotNull int numberOccupants,
        @NotNull int maxNumberOccupants,
        @NotNull boolean ownerOccupied
) {}