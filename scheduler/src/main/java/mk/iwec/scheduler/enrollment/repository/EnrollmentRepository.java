package mk.iwec.scheduler.enrollment.repository;

import mk.iwec.scheduler.enrollment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
