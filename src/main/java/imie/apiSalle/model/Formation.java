package imie.apiSalle.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FORMATION")
@Data
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORMATION")
    private Integer idFormation;

    @Column(name = "NOM_FORMATION", nullable = false, length = 50)
    private String nomFormation;

    // Les constructeurs, getters et setters sont générés par Lombok grâce à l'annotation @Data
}
