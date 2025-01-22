package imie.apiSalle.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SALLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_SALLE")
    private Integer numSalle;

    @Column(name = "NOM_SALLE", nullable = false, length = 50)
    private String nomSalle;

    @Column(name = "NMBR_PLACE", nullable = false)
    private Integer nmbrPlace;

    @Column(name = "DISPONIBILITE", nullable = false)
    private Boolean disponibilite;

    @Column(name = "TYPE_SALLE", nullable = false, length = 20)
    private String typeSalle;
}
