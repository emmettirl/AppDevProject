package AppDev.Project.AppDevProject.model;




import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String animalType;
    private String breed;
    private int age;

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;
}
