package imie.apiSalle.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "PROMOTION")
@Data
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROMOTION")
    private Integer idPromotion;

    @Column(name = "NOM_PROMOTION", nullable = false, length = 20)
    private String nomPromotion;

    @Column(name = "NMBR_ETUDIANT", nullable = false)
    private Integer nmbrEtudiant;

    @Column(name = "ANNEE_SCOLAIRE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date anneeScolaire;

    // Lombok @Data génère les getters, setters, equals, hashCode et toString
}
