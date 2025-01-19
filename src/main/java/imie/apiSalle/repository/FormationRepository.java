package imie.apiSalle.repository;

import imie.apiSalle.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer> {
    // Méthodes CRUD fournies par JpaRepository
}
