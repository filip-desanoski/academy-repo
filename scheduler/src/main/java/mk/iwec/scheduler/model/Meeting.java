package mk.iwec.scheduler.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "meetings")
@Data
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "meeting_name", nullable = false, unique = true)
    private String meetingName;

    @Column(name = "start_time", nullable = false)
    private ZonedDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private ZonedDateTime endTime;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp meetingCreatedAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp meetingUpdatedAt;

    @Column(name = "active")
    private Boolean active;

    @ManyToMany(mappedBy = "meetingsAttended")
    private Set<User> attendees;

    @ManyToMany(mappedBy = "meetingsInstructed")
    private Set<User> instructors;
}
