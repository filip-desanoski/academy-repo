package mk.iwec.scheduler.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_roles")
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role", length = 13)
    private Role role;

    public enum Role {
        ADMINISTRATOR, INSTRUCTOR, USER
    }
}
