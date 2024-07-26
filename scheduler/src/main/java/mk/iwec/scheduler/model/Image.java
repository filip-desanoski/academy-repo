package mk.iwec.scheduler.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "images")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "img_name", columnDefinition = "TEXT", nullable = false, unique = true)
    private String imgName;

    @Column(name = "img", columnDefinition = "BYTEA", nullable = false)
    private byte[] img;
}
