package imie.apiSalle.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "UTILISATEUR_FORMATION")
@IdClass(UtilisateurFormationId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UtilisateurFormation implements Serializable {

    @Id
    @Column(name = "NUM_SALLE", nullable = false)
    private Integer numSalle;

    @Id
    @Column(name = "ID_PROMOTION", nullable = false)
    private Integer idPromotion;

    @Id
    @Column(name = "ID_FORMATION", nullable = false)
    private Integer idFormation;

    @Column(name = "DEBUT_FORMATION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date debutFormation;

    @Column(name = "FIN_FORMATION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date finFormation;

    @Column(name = "RECURRANCE", nullable = false)
    private Boolean recurrance;

    @Column(name = "TYPE_RECU", length = 50)
    private String typeRecu;

    @Column(name = "JOUR_SEMAINE", length = 20)
    private String jourSemaine;

    @Column(name = "JOUR_MOIS")
    private Integer jourMois;
}
