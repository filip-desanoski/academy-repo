package mk.iwec.scheduler.meeting.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.iwec.scheduler.infrastructure.model.BaseEntity;

import java.time.ZonedDateTime;

@Entity
@Table(name = "meetings")
@Data
public class Meeting extends BaseEntity {

    @Column(name = "meeting_name", nullable = false, unique = true)
    private String meetingName;

    @Column(name = "start_time", nullable = false)
    private ZonedDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private ZonedDateTime endTime;

    @Column(name = "active")
    private Boolean active;
}
