package mk.iwec.scheduler.meeting.repository;

import mk.iwec.scheduler.meeting.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
}
