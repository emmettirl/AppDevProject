package AppDev.Project.AppDevProject.repositories;

import AppDev.Project.AppDevProject.entities.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, String> {
}
