package mk.iwec.scheduler.repository;

import mk.iwec.scheduler.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
}
