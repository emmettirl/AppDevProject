package AppDev.Project.AppDevProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pet")
@Data
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
}
