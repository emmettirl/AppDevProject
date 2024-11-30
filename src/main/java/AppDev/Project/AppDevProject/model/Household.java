package AppDev.Project.AppDevProject.model;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Household {
    @Id
    private String eircode;

    private int numberOccupants;
    private int maxOccupants;
    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household", fetch = FetchType.EAGER)
    private List<Pet> pets;
}
