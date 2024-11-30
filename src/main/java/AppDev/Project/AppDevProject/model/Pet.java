package AppDev.Project.AppDevProject.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String animalType;
    private String breed;
    private int age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "household_eircode")
    private Household household;
}
