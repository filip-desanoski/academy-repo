package mk.iwec.scheduler.repository;

import mk.iwec.scheduler.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
