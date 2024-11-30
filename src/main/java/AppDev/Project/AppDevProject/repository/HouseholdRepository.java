package AppDev.Project.AppDevProject.repository;
import AppDev.Project.AppDevProject.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface HouseholdRepository extends JpaRepository<Household, String> {
    List<Household> findByPetsIsNull();
    List<Household> findByOwnerOccupied(boolean ownerOccupied);
}

