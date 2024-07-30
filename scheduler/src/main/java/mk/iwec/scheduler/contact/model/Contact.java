package mk.iwec.scheduler.contact.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.iwec.scheduler.image.model.Image;
import mk.iwec.scheduler.infrastructure.model.BaseEntity;

@Entity
@Table(name = "contacts")
@Data
public class Contact extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false, unique = true)
    private String lastName;

    @Column(name = "phone_number", length = 20, nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
}
