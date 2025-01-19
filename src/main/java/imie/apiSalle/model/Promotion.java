package imie.apiSalle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Promotion {

    @Id
    private Integer idPromotion;
    private String nomPromotion;
    private Integer nmbrEtudiant;
    private String anneeScolaire;

    // Getters and Setters
    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getNomPromotion() {
        return nomPromotion;
    }

    public void setNomPromotion(String nomPromotion) {
        this.nomPromotion = nomPromotion;
    }

    public Integer getNmbrEtudiant() {
        return nmbrEtudiant;
    }

    public void setNmbrEtudiant(Integer nmbrEtudiant) {
        this.nmbrEtudiant = nmbrEtudiant;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }
}
