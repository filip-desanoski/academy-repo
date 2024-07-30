package mk.iwec.scheduler.user.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.iwec.scheduler.contact.model.Contact;
import mk.iwec.scheduler.infrastructure.model.BaseEntity;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {

    @Column(name ="username",unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @ManyToMany
    @JoinTable(
            name = "r_user_userRole",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_role_id")
    )
    private Set<UserRole> userRole;

    @Column(name = "active")
    private Boolean active;
}
