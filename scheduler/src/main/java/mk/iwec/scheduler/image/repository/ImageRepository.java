package mk.iwec.scheduler.image.repository;

import mk.iwec.scheduler.image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
