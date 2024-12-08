package AppDev.Project.AppDevProject.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetDTO(
        @NotBlank String name,
        @NotBlank String animalType,
        @NotBlank String breed,
        @NotNull int age,
        @NotBlank String householdEircode
) {}