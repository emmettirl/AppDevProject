package AppDev.Project.AppDevProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pet")

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
    private Household household;

    // Constructor for name, animalType, and breed
    public Pet(String name, String animalType, String breed) {
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
    }

    public Pet() {
    }
}