package imie.apiSalle.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "UTILISATEUR_FORMATION")
@IdClass(UtilisateurFormationId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurFormation {

    @Id
    @Column(name = "NUM_SALLE")
    private Integer numSalle;

    @Id
    @Column(name = "ID_PROMOTION")
    private Integer idPromotion;

    @Id
    @Column(name = "ID_FORMATION")
    private Integer idFormation;

    @Column(name = "DEBUT_FORMATION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date debutFormation;

    @Column(name = "FIN_FORMATION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date finFormation;

    @Column(name = "RECURRANCE", nullable = false)
    private Boolean recurrance;

    @Column(name = "TYPE_RECU")
    private String typeRecu;

    @Column(name = "JOUR_SEMAINE")
    private String jourSemaine;

    @Column(name = "JOUR_MOIS")
    private Integer jourMois;
}
