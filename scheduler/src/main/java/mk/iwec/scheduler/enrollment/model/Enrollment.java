package mk.iwec.scheduler.enrollment.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.iwec.scheduler.training.model.Training;
import mk.iwec.scheduler.user.model.User;

import java.sql.Timestamp;

@Entity
@Table(name = "enrollments")
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    @Column(name = "enrollment_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp enrollmentDate;
}
