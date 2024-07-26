package mk.iwec.scheduler.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "trainings")
@Data
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "training_name", nullable = false, unique = true)
    private String trainingName;

    @Column(name = "group_id", nullable = false, unique = true)
    private String groudId;

    @Column(name = "start_date", nullable = false)
    private Date trainingStartDate;

    @Column(name = "end_date", nullable = false)
    private Date trainingEndDate;

    @Column(name = "training_crated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp trainingCreatedAt;

    @Column(name = "training_updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp trainingUpdatedAt;

    @Column(name = "active")
    private Boolean active;

    @ManyToMany
    @JoinTable(
            name = "r_training_instructors",
            joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private Set<User> instructors;
}
