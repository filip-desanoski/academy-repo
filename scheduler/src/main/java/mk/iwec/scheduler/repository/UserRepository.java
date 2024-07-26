package mk.iwec.scheduler.repository;

import mk.iwec.scheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
