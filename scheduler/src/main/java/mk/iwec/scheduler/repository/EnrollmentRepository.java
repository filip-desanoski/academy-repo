package mk.iwec.scheduler.repository;

import mk.iwec.scheduler.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
