package imie.apiSalle.repository;

import imie.apiSalle.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    // Méthodes de requête personnalisées peuvent être ajoutées ici
}
