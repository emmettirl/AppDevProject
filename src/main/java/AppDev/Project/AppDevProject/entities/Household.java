package AppDev.Project.AppDevProject.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "household")
public class Household {
    @Id
    private String eircode;

    @Column(nullable = false)
    private int numberOccupants;

    @Column(nullable = false)
    private int maxNumberOccupants;

    @Column(nullable = false)
    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;
}