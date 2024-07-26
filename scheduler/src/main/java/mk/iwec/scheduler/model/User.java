package mk.iwec.scheduler.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="username",unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    private UserRole userRole;

    @Column(name = "user_created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp userCreatedAt;

    @Column(name = "user_updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp userUpdatedAt;

    @Column(name = "active")
    private Boolean active;

    @ManyToMany(mappedBy = "instructors")
    private Set<Training> trainings;

    @ManyToMany
    @JoinTable(
            name = "r_meeting_attendees",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "meeting_id")
    )
    private Set<Meeting> meetingAttendees;

    @ManyToMany
    @JoinTable(
            name = "r_meeting_instructors",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "meeting_id")
    )
    private Set<Meeting> meetingInstructors;
}
