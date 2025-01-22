package imie.apiSalle.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PROMOTION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROMOTION")
    private Integer idPromotion;

    @Column(name = "NOM_PROMOTION", nullable = false, length = 50)
    private String nomPromotion;

    @Column(name = "NMBR_ETUDIANT")
    private Integer nmbrEtudiant;

    @Column(name = "ANNEE_SCOLAIRE", length = 10)
    private String anneeScolaire;
}
