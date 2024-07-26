package mk.iwec.scheduler.repository;

import mk.iwec.scheduler.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
