package AppDev.Project.AppDevProject;



import AppDev.Project.AppDevProject.model.Household;
import AppDev.Project.AppDevProject.model.Pet;
import AppDev.Project.AppDevProject.repository.HouseholdRepository;
import AppDev.Project.AppDevProject.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppDevProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDevProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(PetRepository petRepository, HouseholdRepository householdRepository) {
		return args -> {
			Household household1 = new Household(null, "123 Maple Street", null);
			Household household2 = new Household(null, "456 Oak Avenue", null);

			household1 = householdRepository.save(household1);
			household2 = householdRepository.save(household2);

			Pet pet1 = new Pet(null, "Buddy", "Dog", household1);
			Pet pet2 = new Pet(null, "Mittens", "Cat", household1);
			Pet pet3 = new Pet(null, "Goldie", "Fish", household2);

			petRepository.save(pet1);
			petRepository.save(pet2);
			petRepository.save(pet3);
		};
	}
}
