package AppDev.Project.AppDevProject.graphql;

public record HouseholdInput(String eircode, int numberOccupants, int maxNumberOccupants, boolean ownerOccupied) {}