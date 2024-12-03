package AppDev.Project.AppDevProject.graphql;



public class HouseholdInput {
    private String eircode;
    private int numberOccupants;
    private int maxOccupants;
    private boolean ownerOccupied;

    // Getters and setters

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public int getNumberOccupants() {
        return numberOccupants;
    }

    public void setNumberOccupants(int numberOccupants) {
        this.numberOccupants = numberOccupants;
    }

    public int getMaxOccupants() {
        return maxOccupants;
    }

    public void setMaxOccupants(int maxOccupants) {
        this.maxOccupants = maxOccupants;
    }

    public boolean isOwnerOccupied() {
        return ownerOccupied;
    }

    public void setOwnerOccupied(boolean ownerOccupied) {
        this.ownerOccupied = ownerOccupied;
    }
}
