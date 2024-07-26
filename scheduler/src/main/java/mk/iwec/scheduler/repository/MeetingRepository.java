package mk.iwec.scheduler.repository;

import mk.iwec.scheduler.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
}
