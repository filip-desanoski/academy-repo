package mk.iwec.scheduler.training.repository;

import mk.iwec.scheduler.training.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Integer> {
}
