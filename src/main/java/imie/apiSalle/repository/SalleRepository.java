package imie.apiSalle.repository;

import imie.apiSalle.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Integer> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}
