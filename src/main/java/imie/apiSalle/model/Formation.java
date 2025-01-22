package imie.apiSalle.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "FORMATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORMATION")
    private Integer idFormation;

    @Column(name = "NOM_FORMATION", nullable = false, length = 50)
    private String nomFormation;
}
