package AppDev.Project.AppDevProject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pet")

@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String animalType;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "household_eircode")
    @JsonBackReference
    private Household household;

    // Constructor for name, animalType, and breed
    public Pet(String name, String animalType, String breed) {
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
    }

}