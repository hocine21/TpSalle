package imie.apiSalle.repository;

import imie.apiSalle.model.UtilisateurFormation;
import imie.apiSalle.model.UtilisateurFormationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurFormationRepository extends JpaRepository<UtilisateurFormation, UtilisateurFormationId> {
}
