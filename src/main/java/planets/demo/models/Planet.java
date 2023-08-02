package planets.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Table(name = "planets")
@Entity(name = "planets")
@Data
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "climate")
    private String climate;

    @Column(name = "ground")
    private String ground;
}
