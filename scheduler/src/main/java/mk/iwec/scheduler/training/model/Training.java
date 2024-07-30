package mk.iwec.scheduler.training.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.iwec.scheduler.infrastructure.model.BaseEntity;

import java.util.Date;

@Entity
@Table(name = "trainings")
@Data
public class Training extends BaseEntity {

    @Column(name = "training_name", nullable = false, unique = true)
    private String trainingName;

    @Column(name = "group_id", nullable = false, unique = true)
    private String groudId;

    @Column(name = "start_date", nullable = false)
    private Date trainingStartDate;

    @Column(name = "end_date", nullable = false)
    private Date trainingEndDate;

    @Column(name = "active")
    private Boolean active;
}
