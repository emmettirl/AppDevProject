package AppDev.Project.AppDevProject.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Household {
    @Id
    private String eircode;
    private int numberOccupants;
    private int maxOccupants;
    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household")
    private List<Pet> pets;

    // Add a constructor with parameters
    public Household(String eircode, int numberOccupants, int maxOccupants, boolean ownerOccupied, List<Pet> pets) {
        this.eircode = eircode;
        this.numberOccupants = numberOccupants;
        this.maxOccupants = maxOccupants;
        this.ownerOccupied = ownerOccupied;
        this.pets = pets;
    }

    // Default constructor
    public Household() {}
}
