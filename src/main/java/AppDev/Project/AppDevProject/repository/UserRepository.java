package AppDev.Project.AppDevProject.repository;



import AppDev.Project.AppDevProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

