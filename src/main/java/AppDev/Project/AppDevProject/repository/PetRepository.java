package AppDev.Project.AppDevProject.repository;

import AppDev.Project.AppDevProject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PetRepository extends JpaRepository<Pet, Long> {
}

