package AppDev.Project.AppDevProject.repository;

import AppDev.Project.AppDevProject.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
}

