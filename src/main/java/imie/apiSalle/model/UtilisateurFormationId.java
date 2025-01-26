package imie.apiSalle.model;

import java.io.Serializable;
import java.util.Objects;

public class UtilisateurFormationId implements Serializable {
    private Integer numSalle;
    private Integer idPromotion;
    private Integer idFormation;

    // Constructeur par défaut requis pour JPA
    public UtilisateurFormationId() {}

    // Constructeur avec paramètres
    public UtilisateurFormationId(Integer numSalle, Integer idPromotion, Integer idFormation) {
        this.numSalle = numSalle;
        this.idPromotion = idPromotion;
        this.idFormation = idFormation;
    }

    public Integer getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(Integer numSalle) {
        this.numSalle = numSalle;
    }

    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Integer getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Integer idFormation) {
        this.idFormation = idFormation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurFormationId that = (UtilisateurFormationId) o;
        return Objects.equals(numSalle, that.numSalle) &&
               Objects.equals(idPromotion, that.idPromotion) &&
               Objects.equals(idFormation, that.idFormation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSalle, idPromotion, idFormation);
    }
}
